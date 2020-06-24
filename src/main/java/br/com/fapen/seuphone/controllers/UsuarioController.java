package br.com.fapen.seuphone.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.seuphone.forms.UsuarioForm;
import br.com.fapen.seuphone.models.Usuario;
import br.com.fapen.seuphone.repositories.PerfilRepository;
import br.com.fapen.seuphone.repositories.UsuarioRepository;
import br.com.fapen.seuphone.services.ArquivoService;
import br.com.fapen.seuphone.services.UsuarioService;
import br.com.fapen.seuphone.validations.UsuarioFormValidator;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRep;
	
	@Autowired
	private PerfilRepository perfilRep;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ArquivoService arquivoService;
	
	
	
	@Autowired
	private UsuarioFormValidator usuarioFormValidator;
	
	@InitBinder("usuarioForm")
	protected void init(WebDataBinder binder) {
		binder.setValidator(usuarioFormValidator);
	}

	@GetMapping(name = "listarUsuarios")
	public ModelAndView listUser(@RequestParam(defaultValue = "1") Integer pagina,
			@RequestParam(defaultValue = "") String busca, Principal principal) {
		
		Page<Usuario> listaUsuarios = usuarioService.listarUsuarios(busca, pagina, principal);

		ModelAndView mav = new ModelAndView("usuario/listar");
		mav.addObject("listaPaginada", listaUsuarios);

		return mav;
	}
	
	@GetMapping(value = "/novo", name = "novoUsuario")
	public ModelAndView newUser(UsuarioForm usuarioForm) {
		
		System.out.println(usuarioForm.isInclusao());
		
		ModelAndView mav = new ModelAndView("/usuario/novo");
		mav.addObject("listaPerfis", perfilRep.findAll());
		return mav;
	}
	
	@PostMapping(value = "/salvar", name = "salvarUsuario")
	public ModelAndView createUser(@Valid UsuarioForm usuarioForm, BindingResult resultadoValidacao ,RedirectAttributes atributos) {
		
		if(resultadoValidacao.hasErrors()) {
			
			return newUser(usuarioForm);
		}
		if(usuarioForm.getUsuario().getCaminhoFoto() == "") {
			usuarioForm.getUsuario().setCaminhoFoto(null);
		}
		
		usuarioService.salvar(usuarioForm);
		
		atributos.addFlashAttribute("mensagemStatus", "Usuário salvo com sucesso!");
		
		return new ModelAndView("redirect:/usuarios");
	}
	
	@GetMapping(value = "/{id}/editar", name = "editarUsuario")
	public ModelAndView editUser(@PathVariable Long id, Model model) {
		
		Usuario usuario = usuarioRep.getOne(id);
		
		UsuarioForm usuarioForm = new UsuarioForm(usuario);
		
		model.addAttribute(usuarioForm);
		
		return newUser(usuarioForm);
	}
	
	@PostMapping(value = "/{id}/apagar", name = "apagarUsuario")
	public String inativar(@PathVariable Long id, RedirectAttributes atributos) {
		Usuario usuario = usuarioRep.findOneByIdLogin(id);
	
		usuario.setInativo(true);

		usuarioRep.save(usuario);
		atributos.addFlashAttribute("mensagemStatus", "Usuario apagado com sucesso!");
		
		return "redirect:/usuarios";
	}
	
	@GetMapping(value = "/{id}", name = "visualizarUsuario")
	public ModelAndView viewUser(@PathVariable Long id) {
		Usuario usuario = usuarioRep.getOne(id);
		UsuarioForm usuarioForm = new UsuarioForm(usuario);
		
		ModelAndView mav = new ModelAndView("/usuario/visualizar");
		mav.addObject("usuarioForm", usuarioForm);
		
		return mav;
	}
	
	@GetMapping(value = "/meuperfil", name = "meuPerfil")
	public ModelAndView myProfile(Principal principal) {
		Usuario perfil = usuarioRep.findByLogin(principal.getName());
		perfil.getCaminhoFoto();
		
		ModelAndView mav = new ModelAndView("/usuario/perfil");
		mav.addObject("perfil", perfil);
		
		return mav;
	}
	
	@PostMapping(value = "/alterarFoto", name = "alterarFotoPerfil")
	public String alterarFotoPerfil(MultipartFile foto, Principal principal) {
		
		String caminhoDaFoto = arquivoService.salvarArquivo(foto);
		Usuario usuario = usuarioRep.findByLogin(principal.getName());
		usuario.setCaminhoFoto(caminhoDaFoto);
		usuarioRep.save(usuario);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(usuario, usuario.getSenha(), usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return "redirect:/usuarios/meuperfil";
	}
	
}
