package br.com.fapen.seuphone.DTO;

public class ResponseEstoqueDTO {

	private boolean temEstoque;
	private int quantidade_estoque;
	
	public boolean isTemEstoque() {
		return temEstoque;
	}
	public void setTemEstoque(boolean temEstoque) {
		this.temEstoque = temEstoque;
	}
	public int getQuantidade_estoque() {
		return quantidade_estoque;
	}
	public void setQuantidade_estoque(int quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}
	
	
}
