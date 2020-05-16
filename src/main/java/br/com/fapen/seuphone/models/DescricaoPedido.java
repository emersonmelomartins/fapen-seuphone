package br.com.fapen.seuphone.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "tb_descricao_pedido")
public class DescricaoPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_descricao")
	private Long idDescricao;
	
	@ManyToOne
	private PedidoCompra pedido;
	
	@ManyToOne
	private Produto produto;
	
	private Double quantidade;
	
	@Column(name = "preco_unitario")
	private BigDecimal precoUnitario;

	public Long getIdDescricao() {
		return idDescricao;
	}

	public void setIdDescricao(Long idDescricao) {
		this.idDescricao = idDescricao;
	}

	public PedidoCompra getPedido() {
		return pedido;
	}

	public void setPedido(PedidoCompra pedido) {
		this.pedido = pedido;
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
	
	
}
