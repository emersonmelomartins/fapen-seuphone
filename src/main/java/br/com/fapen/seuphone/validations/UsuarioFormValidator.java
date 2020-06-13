package br.com.fapen.seuphone.validations;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.fapen.seuphone.forms.UsuarioForm;
import br.com.fapen.seuphone.repositories.UsuarioRepository;

@Component
public class UsuarioFormValidator implements Validator {

	private CPFValidator cpfValidator = new CPFValidator();

	@Autowired
	private UsuarioRepository usuarioRep;

	@Override
	public boolean supports(Class<?> clazz) {
		return UsuarioForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "usuario.login", "campo.obrigatorio");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "usuario.email", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "usuario.pessoa.nome", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "usuario.pessoa.cpf", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "usuario.pessoa.dtNascimento", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "usuario.pessoa.sexo", "campo.obrigatorio");

		UsuarioForm usuarioForm = (UsuarioForm) target;

		// Verifica se senha é necessário (inclusão)
		if (usuarioForm.isInclusao()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "usuario.senha", "campo.obrigatorio");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmaSenha", "campo.obrigatorio");
			
			if(!usuarioForm.getUsuario().getSenha().equals(usuarioForm.getConfirmaSenha())) {
				errors.rejectValue("usuario.senha", "senha.diferente");
			}
		}

		// Verifica a idade do usuario
		if(usuarioForm.getUsuario().getPessoa().getDtNascimento() != null) {
			LocalDate dataAniversario = usuarioForm.getUsuario().getPessoa().getDtNascimento();
			LocalDate dataAtual = LocalDate.now();
			
			Period idade = Period.between(dataAniversario, dataAtual);
			
			if(idade.getYears() < 18) {
				errors.rejectValue("usuario.pessoa.dtNascimento", "idade.invalido");
			}
		}
		

		// Verifica se login existe
		if (usuarioRep.existsByLogin(usuarioForm.getUsuario().getLogin())
				&& !usuarioRep.findByLogin(usuarioForm.getUsuario().getLogin()).getIdLogin()
						.equals(usuarioForm.getUsuario().getIdLogin())) {
			errors.rejectValue("usuario.login", "login.existente");
		}

		// Verifica se existe perfil
		if (usuarioForm.getListaPerfil().isEmpty()) {
			errors.rejectValue("listaPerfil", "campo.obrigatorio");
		}

		// Verifica se é um email válido
		String userEmail = usuarioForm.getUsuario().getEmail();
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(userEmail);

		if (!m.matches()) {
			errors.rejectValue("usuario.email", "email.invalido");
		}

		// Verifica se email existe
		if (usuarioForm.getUsuario().getEmail() != null) {
			if (usuarioRep.existsByEmail(usuarioForm.getUsuario().getEmail())
					&& !usuarioRep.findByEmail(usuarioForm.getUsuario().getEmail()).getIdLogin()
							.equals(usuarioForm.getUsuario().getIdLogin())) {
				errors.rejectValue("usuario.email", "email.existente");
			}
		}

		// Validação de CPF
		List<ValidationMessage> validationMessages = cpfValidator
				.invalidMessagesFor(usuarioForm.getUsuario().getPessoa().getCpf());

		if (usuarioForm.getUsuario().getPessoa().getCpf() != null) {
			if (!validationMessages.isEmpty()) {
				errors.rejectValue("usuario.pessoa.cpf", "cpf.invalido");
			}

			// Verifica se CPF já existe
			if (usuarioRep.existsByPessoaCpf(usuarioForm.getUsuario().getPessoa().getCpf())
					&& !usuarioRep.findByPessoaCpf(usuarioForm.getUsuario().getPessoa().getCpf()).getIdLogin()
							.equals(usuarioForm.getUsuario().getIdLogin())) {
				errors.rejectValue("usuario.pessoa.cpf", "cpf.existente");
			}

		}

	}

}
