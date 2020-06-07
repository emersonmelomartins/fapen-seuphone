package br.com.fapen.seuphone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.seuphone.forms.ContatoSiteForm;
import br.com.fapen.seuphone.services.EmailService;
import br.com.fapen.seuphone.templates.HtmlTemplate;

@Controller
public class HomeController {
	
	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/home", method = RequestMethod.GET, name = "paginaHome")
	public String homeController() {
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@PostMapping(value = "/enviar-email", name = "contatoViaSite")
	public String contatoViaSite(ContatoSiteForm contatoSiteForm, RedirectAttributes atributos) {
		
		emailService.enviarEmailHtml("seuphone.apple@gmail.com", "Contato via Site", HtmlTemplate.contatoViaSite(contatoSiteForm));
		
		atributos.addFlashAttribute("mensagemSucesso", "Sua mensagem foi enviada, logo entraremos em contato!");
		return "redirect:/home";
	}
	
	
}
