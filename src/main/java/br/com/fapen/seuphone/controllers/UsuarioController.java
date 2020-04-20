package br.com.fapen.seuphone.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.seuphone.models.Usuario;
import br.com.fapen.seuphone.repositories.Paginacao;
import br.com.fapen.seuphone.repositories.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	// Criar validação para:
	/*
	 * Email duplicado
	 * Email repetido
	 * Campos vazios
	 * Validar email (email@algumacoisa.com)
	 */

	@Autowired
	private UsuarioRepository usuarioRep;

	@GetMapping(name = "listarUsuarios")
	public ModelAndView listUser(@RequestParam(defaultValue = "1") Integer pagina,
			@RequestParam(defaultValue = "") String busca) {

		Page<Usuario> listaUsuarios;
		if (busca.equals("")) {
			listaUsuarios = usuarioRep.findAllByOrderByIdLoginAsc(Paginacao.getPaginacao(pagina));
		} else {
			listaUsuarios = usuarioRep.findByLoginContainingIgnoreCase(busca, Paginacao.getPaginacao(pagina));
		}

		ModelAndView mav = new ModelAndView("usuario/listar");
		mav.addObject("listaPaginada", listaUsuarios);

		return mav;
	}
	
	@GetMapping(value = "/novo", name = "novoUsuario")
	public String newUser(Usuario usuario) {
		
		return "usuario/novo";
	}
	
	@PostMapping(value = "/salvar", name = "salvarUsuario")
	public String createUser(Usuario usuario, RedirectAttributes atributos) {
		
		usuarioRep.save(usuario);
		
		atributos.addFlashAttribute("mensagemStatus", "Usuário salvo com sucesso!");
		
		return "redirect:/usuarios";
	}
	
	@GetMapping(value = "/{id}/editar", name = "editarUsuario")
	public ModelAndView editUser(@PathVariable Long id) {
		
		Usuario usuario = usuarioRep.getOne(id);
		
		ModelAndView mav = new ModelAndView("/usuario/novo");
		mav.addObject("usuario", usuario);
		
		return mav;
	}
	
	@PostMapping(value = "/{id}/apagar", name = "apagarUsuario")
	public String deleteUser(@PathVariable Long id, RedirectAttributes atributos) {
		
		Usuario usuario = usuarioRep.getOne(id);
		usuarioRep.delete(usuario);
		
		atributos.addFlashAttribute("mensagemStatus", "Usuario apagado com sucesso!");
		
		return "redirect:/usuarios";
	}
	
	@GetMapping(value = "/{id}", name = "visualizarUsuario")
	public ModelAndView viewUser(@PathVariable Long id) {
		Usuario usuario = usuarioRep.getOne(id);
		
		ModelAndView mav = new ModelAndView("/usuario/visualizar");
		mav.addObject("usuario", usuario);
		
		return mav;
	}
	
	@GetMapping(value = "/meuperfil", name = "meuPerfil")
	public ModelAndView myProfile(Principal principal) {
		Usuario perfil = usuarioRep.findByLogin(principal.getName());
		
		ModelAndView mav = new ModelAndView("/usuario/perfil");
		mav.addObject("perfil", perfil);
		
		return mav;
	}
}
