package br.com.fapen.seuphone.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "tb_itens_pedido")
public class DescricaoPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_itens_pedido")
	private Long idDescricao;
	
	@ManyToOne
	private PedidoCompra pedido;
	
	@ManyToOne
	private Produto produto;
	
	private Double quantidade;
	
	private BigDecimal valor;
	

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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal calculaQtdTotal(BigDecimal valor, Double quantidade) {
		BigDecimal roundedValor = valor.setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal qtd = new BigDecimal(quantidade);
		BigDecimal total = roundedValor.multiply(qtd);
		
		return total;
	}
	
	
}
