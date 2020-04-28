package br.com.fapen.seuphone.validations;

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
import br.com.fapen.seuphone.models.Usuario;
import br.com.fapen.seuphone.repositories.UsuarioRepository;

@Component
public class UsuarioValidator implements Validator {
	
	private CPFValidator cpfValidator = new CPFValidator();
	
	@Autowired
	private UsuarioRepository usuarioRep;

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "senha", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pessoa.nome", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pessoa.cpf", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pessoa.dtNascimento", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pessoa.sexo", "campo.obrigatorio");
		
		Usuario usuario = (Usuario) target;
		
		String userEmail = usuario.getEmail();
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(userEmail);
		
		if(!m.matches()) {
			errors.rejectValue("email", "email.invalido");
		}
		
		List<ValidationMessage> validationMessages = cpfValidator.invalidMessagesFor(usuario.getPessoa().getCpf());

		

		if (usuario.getPessoa().getCpf() != null) {
			if (!validationMessages.isEmpty()) {
				errors.rejectValue("pessoa.cpf", "cpf.invalido");
			}
			
			if(usuarioRep.existsByPessoaCpf(usuario.getPessoa().getCpf()) && !usuarioRep.findByPessoaCpf(usuario.getPessoa().getCpf()).getIdLogin().equals(usuario.getIdLogin())) {
				errors.rejectValue("pessoa.cpf", "cpf.existente");
			}

		}
		
	}

}
