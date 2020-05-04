package br.com.fapen.seuphone.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.seuphone.models.Perfil;
import br.com.fapen.seuphone.repositories.Paginacao;
import br.com.fapen.seuphone.repositories.PerfilRepository;
import br.com.fapen.seuphone.validations.PerfilValidator;

@Controller
@RequestMapping("/perfis")
public class PerfilController {
	
	@Autowired
	private PerfilRepository perfilRep;
	
	@Autowired
	private PerfilValidator perfilValidator;
	
	@InitBinder("perfil")
	protected void init(WebDataBinder binder) {
		binder.setValidator(perfilValidator);
	}

	
	@GetMapping(name = "listarPerfis")
	public ModelAndView listProfile(@RequestParam(defaultValue = "1") Integer pagina,
			@RequestParam(defaultValue = "") String busca) {

		Page<Perfil> listaPerfis;
		if (busca.equals("")) {
			listaPerfis = perfilRep.findAllByOrderByAuthorityAsc(Paginacao.getPaginacao(pagina));
		} else {
			listaPerfis = perfilRep.findByAuthorityContainingIgnoreCase(busca, Paginacao.getPaginacao(pagina));
		}

		ModelAndView mav = new ModelAndView("perfil/listar");
		mav.addObject("listaPaginada", listaPerfis);

		return mav;
	}
	
	@GetMapping(value = "/novo", name = "novoPerfil")
	public String newProfile(Perfil perfil) {
		
		return "perfil/novo";
	}
	
	@PostMapping(value = "/salvar", name = "salvarPerfil")
	public String createProfile(@Valid Perfil perfil, BindingResult resultadoValidacao, RedirectAttributes atributos) {
		
		if(resultadoValidacao.hasErrors()) {
			
			return newProfile(perfil);
		}
		
		perfilRep.save(perfil);
		
		atributos.addFlashAttribute("mensagemStatus", "Perfil salvo com sucesso!");
		
		return "redirect:/perfis";
	}
	
	@GetMapping(value = "/{id}/editar", name = "editarPerfil")
	public ModelAndView editProfile(@PathVariable String id) {
		
		Perfil perfil = perfilRep.getOne(id);
		
		ModelAndView mav = new ModelAndView("/perfil/novo");
		mav.addObject("perfil", perfil);
		
		return mav;
	}
	
	@PostMapping(value = "/{id}/apagar", name = "apagarPerfil")
	public String inativarProfile(@PathVariable String id, RedirectAttributes atributos) {
		
		Perfil perfil = perfilRep.getOne(id);
		perfilRep.delete(perfil);
		
		atributos.addFlashAttribute("mensagemStatus", "Perfil apagado com sucesso!");
		
		return "redirect:/perfis";
	}
	
	
}
