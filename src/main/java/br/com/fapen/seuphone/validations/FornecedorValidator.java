package br.com.fapen.seuphone.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.fapen.seuphone.models.Fornecedor;

@Component
public class FornecedorValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Fornecedor.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "razaoSocial", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cnpj", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tel", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoriaProduto", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endereco.uf", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endereco.cidade", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endereco.logradouro", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endereco.bairro", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endereco.cep", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endereco.numero", "campo.obrigatorio");

	}

}
