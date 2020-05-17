package br.com.fapen.seuphone.enums;

public enum CondicaoPagtoEnum {


	DINHEIRO("Dinheiro"), 
	CARTAO_DEBITO("Cartão de Débito"), 
	CARTAO_CREDITO("Cartão de Crédito"), 
	BOLETO("Boleto");
	
	private final String displayValue;
	
	private CondicaoPagtoEnum(String displayValue) {
		this.displayValue = displayValue;
	}
	
	public String getDisplayValue() {
		return displayValue;
	}
}
