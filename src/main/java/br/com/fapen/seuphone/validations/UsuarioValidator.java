package br.com.fapen.seuphone.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.fapen.seuphone.models.Usuario;

@Component
public class UsuarioValidator implements Validator {

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
		
		
	}

}
