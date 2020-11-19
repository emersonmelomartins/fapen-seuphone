package br.com.fapen.seuphone.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.seuphone.DTO.RecoverPasswordDTO;
import br.com.fapen.seuphone.DTO.ResponseRecoverPasswordDTO;
import br.com.fapen.seuphone.forms.RecuperarSenhaForm;
import br.com.fapen.seuphone.models.Usuario;
import br.com.fapen.seuphone.repositories.UsuarioRepository;
import br.com.fapen.seuphone.services.EmailService;
import br.com.fapen.seuphone.services.UsuarioService;
import br.com.fapen.seuphone.templates.HtmlTemplate;
import br.com.fapen.seuphone.validations.RecuperarSenhaFormValidator;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/esqueci-senha")
public class RecuperarSenhaApiController {

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

	@CrossOrigin
	@PostMapping
	public ResponseEntity<ResponseRecoverPasswordDTO> verificarEmail(
			@RequestBody RecoverPasswordDTO recoverPasswordDto) {

		ResponseRecoverPasswordDTO message = new ResponseRecoverPasswordDTO();

		String email = recoverPasswordDto.getEmail();

		boolean verificaEmail = usuarioRep.existsByEmail(email);

		if (!verificaEmail) {
			message.setMessage("Não foi encontrado o e-mail informado.");

			message.setStatus(HttpStatus.NOT_FOUND);

			return new ResponseEntity<ResponseRecoverPasswordDTO>(message, HttpStatus.NOT_FOUND);
		} else {

			Usuario buscaUsuario = usuarioRep.findByEmail(email);

			String novoHash = usuarioService.gerarHash(email);
			usuarioRep.alterarHash(novoHash, buscaUsuario.getIdLogin());

			emailService.enviarEmailHtml(email, "Recuperação de Senha - Seuphone",
					HtmlTemplate.recuperarSenha(novoHash, buscaUsuario.getPessoa().getNome()));

			message.setMessage("Foi enviado um email de recuperação para " + recoverPasswordDto.getEmail() + ".");
			message.setStatus(HttpStatus.CREATED);

			return new ResponseEntity<ResponseRecoverPasswordDTO>(message, HttpStatus.CREATED);

		}

	}
}
