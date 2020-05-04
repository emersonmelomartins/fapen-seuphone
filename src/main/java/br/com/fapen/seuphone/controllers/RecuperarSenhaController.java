package br.com.fapen.seuphone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.seuphone.models.Usuario;
import br.com.fapen.seuphone.repositories.UsuarioRepository;
import br.com.fapen.seuphone.services.EmailService;
import br.com.fapen.seuphone.services.UsuarioService;

@Controller
public class RecuperarSenhaController {
	
	@Autowired
	private UsuarioRepository usuarioRep;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EmailService emailService;

	@GetMapping(value = "/esqueci-senha", name = "esqueciSenha")
	public String esqueciSenha() {
		return "recuperar-senha/form";
	}
	
	@PostMapping(name = "verificarEmail")
	public String verificarEmail(Usuario usuario, RedirectAttributes atributos) {
		String email = usuario.getEmail();
		Usuario buscaUsuario =  usuarioRep.findByEmail(email);
		boolean verificaEmail = usuarioRep.existsByEmail(email);
		
		if(!verificaEmail) {
			atributos.addFlashAttribute("mensagemErro", "Não foi encontrado o e-mail informado.");
			return "redirect:/esqueci-senha";
		}
		String novoHash = usuarioService.gerarHash(email);
		usuarioRep.alterarHash(novoHash, buscaUsuario.getIdLogin());
		
		atributos.addFlashAttribute("mensagemSucesso", "Foi enviado um email de recuperação para <span class='indigo-text darken-1'>" + usuario.getEmail() + "</b>");
		return "redirect:/esqueci-senha";
	}
	
	public String recuperarSenha() {
		return "";
	}
}
