package br.com.fapen.seuphone.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.seuphone.forms.RecuperarSenhaForm;
import br.com.fapen.seuphone.models.Usuario;
import br.com.fapen.seuphone.repositories.UsuarioRepository;
import br.com.fapen.seuphone.services.EmailService;
import br.com.fapen.seuphone.services.UsuarioService;
import br.com.fapen.seuphone.templates.HtmlTemplate;
import br.com.fapen.seuphone.validations.RecuperarSenhaFormValidator;

@Controller
public class RecuperarSenhaController {
	
	@Autowired
	private UsuarioRepository usuarioRep;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private RecuperarSenhaFormValidator recuperarSenhaFormValidator;
	
	@InitBinder("recuperarSenhaForm")
	protected void init(WebDataBinder binder) {
		binder.setValidator(recuperarSenhaFormValidator);
	}
	

	@GetMapping(value = "/esqueci-senha", name = "esqueciSenha")
	public String esqueciSenha() {
		return "recuperar-senha/form";
	}
	
	@PostMapping(name = "verificarEmail")
	public String verificarEmail(RecuperarSenhaForm recuperarSenhaForm, RedirectAttributes atributos) {
		String email = recuperarSenhaForm.getUsuario().getEmail();
		Usuario buscaUsuario =  usuarioRep.findByEmail(email);
		boolean verificaEmail = usuarioRep.existsByEmail(email);
		
		if(!verificaEmail) {
			atributos.addFlashAttribute("mensagemErro", "Não foi encontrado o e-mail informado.");
			return "redirect:/esqueci-senha";
		}
		String novoHash = usuarioService.gerarHash(email);
		usuarioRep.alterarHash(novoHash, buscaUsuario.getIdLogin());
		
		emailService.enviarEmailHtml(email, "Recuperação de Senha - Seuphone", HtmlTemplate.recuperarSenha(novoHash, buscaUsuario.getPessoa().getNome()));
		
		atributos.addFlashAttribute("mensagemSucesso", "Foi enviado um email de recuperação para <span class='cyan-text darken-1'>" + recuperarSenhaForm.getUsuario().getEmail() + "</b>");
		return "redirect:/esqueci-senha";
	}
	
	@GetMapping("/recuperar-senha")
	public ModelAndView verificaToken(@RequestParam(defaultValue = "") String token, RedirectAttributes atributos) {
		
		if(token.equals("")) {
			atributos.addFlashAttribute("mensagemErro", "É necessário informar um token!");
			return new ModelAndView("redirect:/esqueci-senha");
		}
		
		boolean verificaToken = usuarioRep.existsByHash(token);
		if(!verificaToken) {
			atributos.addFlashAttribute("mensagemErro", "Token Inválido!");
			return new ModelAndView("redirect:/esqueci-senha");
		}
		RecuperarSenhaForm recuperarSenhaForm = new RecuperarSenhaForm(usuarioRep.findByHash(token));
		
		return formularioNovaSenha(recuperarSenhaForm);
	}
	
	@GetMapping("/formulario-senha")
	public ModelAndView formularioNovaSenha(RecuperarSenhaForm recuperarSenhaForm) {
		ModelAndView mav = new ModelAndView("/recuperar-senha/trocar");
		mav.addObject("recuperarSenhaForm", recuperarSenhaForm);
		return mav;
	}
	
	@PostMapping(value = "/trocar-senha", name = "trocarSenha")
	public ModelAndView trocaSenha(@Valid RecuperarSenhaForm recuperarSenhaForm, BindingResult resultadoValidacao, RedirectAttributes atributos) {
		
		if(resultadoValidacao.hasErrors()) {
			
			return formularioNovaSenha(recuperarSenhaForm);
		}
		
		String novaSenha = recuperarSenhaForm.getNovoPassword();
		Long id = recuperarSenhaForm.getUsuario().getIdLogin();
		
		usuarioService.alterarSenha(novaSenha, id);
		atributos.addFlashAttribute("mensagemSucesso", "Senha alterada com sucesso!");
		return new ModelAndView("redirect:/login");
	}
}
