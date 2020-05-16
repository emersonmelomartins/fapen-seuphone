package br.com.fapen.seuphone.enums;

public enum StatusPedidoEnum {

	EM_DIGITACAO("Em Digitação"),
	RECEBIDO("Recebido"),
	CANCELADO("Cancelado");

	private final String displayValue;

	private StatusPedidoEnum(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
}
