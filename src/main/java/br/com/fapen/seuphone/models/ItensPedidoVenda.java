package br.com.fapen.seuphone.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "tb_itens_pedido_venda")
public class ItensPedidoVenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_itens_pedido_venda")
	private Long idItensPedidoVenda;
	
	@JsonIgnore
	@ManyToOne
	private PedidoVenda pedido_venda;
	
	@ManyToOne
	private Produto produto;
	
	private Double quantidade;
	
	private BigDecimal valor;

	public Long getIdItensPedidoVenda() {
		return idItensPedidoVenda;
	}

	public void setIdItensPedidoVenda(Long idItensPedidoVenda) {
		this.idItensPedidoVenda = idItensPedidoVenda;
	}

	public PedidoVenda getPedido_venda() {
		return pedido_venda;
	}

	public void setPedido_venda(PedidoVenda pedido_venda) {
		this.pedido_venda = pedido_venda;
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	

}
