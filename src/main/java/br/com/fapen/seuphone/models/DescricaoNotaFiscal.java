package br.com.fapen.seuphone.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "tb_descricao_nota_fiscal")
public class DescricaoNotaFiscal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_descricao_nota_fiscal")
	private Long idDescricaoNotaFiscal;
	
	@ManyToOne
	private NotaFiscal notaFiscal;
	
	@ManyToOne
	private Produto produto;
	
	private Double quantidade;
	private BigDecimal precoUnitario;
	private BigDecimal valorTotal;
	public Long getIdDescricaoNotaFiscal() {
		return idDescricaoNotaFiscal;
	}
	public void setIdDescricaoNotaFiscal(Long idDescricaoNotaFiscal) {
		this.idDescricaoNotaFiscal = idDescricaoNotaFiscal;
	}
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
