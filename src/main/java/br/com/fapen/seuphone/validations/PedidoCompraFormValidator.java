package br.com.fapen.seuphone.validations;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.fapen.seuphone.forms.PedidoCompraForm;
import br.com.fapen.seuphone.models.DescricaoPedido;

@Component
public class PedidoCompraFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PedidoCompraForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pedidoCompra.fornecedor", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pedidoCompra.dtEntrega", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pedidoCompra.condicaoPagamento", "campo.obrigatorio");

		PedidoCompraForm formulario = (PedidoCompraForm) target;
		if (formulario.getItensPedidoCompra().isEmpty()) {
			errors.rejectValue("itensPedidoCompra", "lista.vazia");
		}

		for (int i = 0; i < formulario.getItensPedidoCompra().size(); i++) {
			DescricaoPedido itemPedido = formulario.getItensPedidoCompra().get(i);

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itensPedidoCompra[" + i + "].produto",
					"campo.obrigatorio");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itensPedidoCompra[" + i + "].quantidade",
					"campo.obrigatorio");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itensPedidoCompra[" + i + "].valor",
					"campo.obrigatorio");

			if (itemPedido.getQuantidade() != null && itemPedido.getQuantidade().compareTo(0d) == 0) {
				errors.rejectValue("itensPedido[" + i + "].quantidade", "campo.obrigatorio");
			}
			if (itemPedido.getValor() != null && itemPedido.getValor().compareTo(BigDecimal.ZERO) == 0) {
				errors.rejectValue("itensPedido[" + i + "].precoUnitario", "campo.obrigatorio");
			}
		}

	}

}
