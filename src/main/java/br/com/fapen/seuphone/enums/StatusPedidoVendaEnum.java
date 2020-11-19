package br.com.fapen.seuphone.enums;

public enum StatusPedidoVendaEnum {

	AGUARDANDO("Aguardando"),
	RECEBIDO("Recebido");

	private final String displayValue;

	private StatusPedidoVendaEnum(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
}
