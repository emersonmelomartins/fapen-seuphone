package br.com.fapen.seuphone.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.fapen.seuphone.forms.RecuperarSenhaForm;

@Component
public class RecuperarSenhaFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return RecuperarSenhaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "novoPassword", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmarPassword", "campo.obrigatorio");
		
		RecuperarSenhaForm rsf = (RecuperarSenhaForm) target;
		
		if(rsf.getNovoPassword() != null) {
			if(!rsf.getNovoPassword().equals(rsf.getConfirmarPassword())) {
				errors.rejectValue("confirmarPassword", "senha.diferente");
			}
		}
		
	}

}
