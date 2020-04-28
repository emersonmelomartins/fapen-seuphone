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
import br.com.caelum.stella.validation.CNPJValidator;
import br.com.fapen.seuphone.models.Fornecedor;
import br.com.fapen.seuphone.repositories.FornecedorRepository;

@Component
public class FornecedorValidator implements Validator {

	CNPJValidator cnpjValidator = new CNPJValidator();

	@Autowired
	private FornecedorRepository fornecedorRep;

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

		Fornecedor fornecedor = (Fornecedor) target;

		String providerEmail = fornecedor.getEmail();
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(providerEmail);

		if (!m.matches()) {
			errors.rejectValue("email", "email.invalido");
		}

		List<ValidationMessage> validationMessages = cnpjValidator.invalidMessagesFor(fornecedor.getCnpj());

		

		if (fornecedor.getCnpj() != null) {
			if (!validationMessages.isEmpty()) {
				errors.rejectValue("cnpj", "cnpj.invalido");
			}
			
			if (fornecedorRep.existsByCnpj(fornecedor.getCnpj())) {	
				if(!fornecedorRep.findByCnpj(fornecedor.getCnpj()).getId().equals(fornecedor.getId())) {
					errors.rejectValue("cnpj", "cnpj.existente");
				}
			}

			

		}
	}

}
