package br.com.fapen.seuphone.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.fapen.seuphone.forms.DescricaoRecebimentoForm;
import br.com.fapen.seuphone.forms.RecebimentoForm;

@Component
public class RecebimentoFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return RecebimentoForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "serieNotaFiscal", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numeroNotaFiscal", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dtNotaFiscal", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dtRecebimento", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pedido", "campo.obrigatorio");
		
		RecebimentoForm formulario = (RecebimentoForm) target;
		
		for (int i = 0; i < formulario.getItens().size(); i++) {
			DescricaoRecebimentoForm itens = formulario.getItens().get(i);

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itens[" + i + "].verificado",
					"campo.obrigatorio");

			if(!itens.isVerificado()) {
				errors.rejectValue("itens[" + i + "].verificado", "verificacao.obrigatorio");
			}
		}
		
	}

}
