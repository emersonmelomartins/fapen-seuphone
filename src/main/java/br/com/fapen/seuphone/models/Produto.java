package br.com.fapen.seuphone.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long idProduto;
	
	@Column(name = "tipo_produto", length = 100)
	private String tipoProduto;
	
	@Column(length = 100)
	private String modelo;
	
	@Column(nullable = false)
	private Double valor;
	
	@Column(length = 100)
	private String peso;
	
	@Column(length = 100)
	private String cor;
	
	@Column(length = 255)
	private String descricao;
	
	@Column(name = "cor_em_hexadecimal")
	private String corEmHexadecimal;
	
	@Column
	private String capacidade;
	
	@Column(name = "quantidade_estoque")
	private int quantidadeEstoque;
	
	@Column(name = "caminho_foto")
	private String caminhoFoto;
	
	private String fotoEmString;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_fornecedor")
	private Fornecedor fornecedor;
	
	@Column(columnDefinition = "boolean default false")
	private boolean inativo;


	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public boolean isInativo() {
		return inativo;
	}

	public void setInativo(boolean inativo) {
		this.inativo = inativo;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getCaminhoFoto() {
		return caminhoFoto;
	}

	public void setCaminhoFoto(String caminhoFoto) {
		this.caminhoFoto = caminhoFoto;
	}

	public String getFotoEmString() {
		return fotoEmString;
	}

	public void setFotoEmString(String fotoEmString) {
		this.fotoEmString = fotoEmString;
	}

	public String getCorEmHexadecimal() {
		return corEmHexadecimal;
	}

	public void setCorEmHexadecimal(String corEmHexadecimal) {
		this.corEmHexadecimal = corEmHexadecimal;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", tipoProduto=" + tipoProduto + ", modelo=" + modelo + ", valor="
				+ valor + ", peso=" + peso + ", cor=" + cor + ", descricao=" + descricao + ", corEmHexadecimal="
				+ corEmHexadecimal + ", capacidade=" + capacidade + ", quantidadeEstoque=" + quantidadeEstoque
				+ ", caminhoFoto=" + caminhoFoto + ", fotoEmString=" + fotoEmString + ", fornecedor=" + fornecedor
				+ ", inativo=" + inativo + ", getIdProduto()=" + getIdProduto() + ", getTipoProduto()="
				+ getTipoProduto() + ", getModelo()=" + getModelo() + ", getValor()=" + getValor() + ", getPeso()="
				+ getPeso() + ", getCor()=" + getCor() + ", getDescricao()=" + getDescricao()
				+ ", getQuantidadeEstoque()=" + getQuantidadeEstoque() + ", isInativo()=" + isInativo()
				+ ", getFornecedor()=" + getFornecedor() + ", getCaminhoFoto()=" + getCaminhoFoto()
				+ ", getFotoEmString()=" + getFotoEmString() + ", getCorEmHexadecimal()=" + getCorEmHexadecimal()
				+ ", getCapacidade()=" + getCapacidade() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
