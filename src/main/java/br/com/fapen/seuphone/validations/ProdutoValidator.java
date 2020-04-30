package br.com.fapen.seuphone.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.fapen.seuphone.models.Produto;

@Component
public class ProdutoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descricao", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tipoProduto", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "modelo", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cor", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "peso", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "valor", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fornecedor", "campo.obrigatorio");
	}
}
