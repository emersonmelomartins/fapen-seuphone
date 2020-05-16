package br.com.fapen.seuphone.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.com.fapen.seuphone.enums.StatusPedidoEnum;

@Entity(name = "tb_pedido_compra")
public class PedidoCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long idPedido;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "dt_pedido")
	private LocalDate dtPedido;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "situacao_pedido")
	private StatusPedidoEnum situacaoPedido;
	
	@Column(name = "valor_final")
	private BigDecimal valorFinal;
	
	@Column(columnDefinition = "boolean default false")
	private boolean inativo;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DescricaoPedido> itens = new ArrayList<DescricaoPedido>();
	
	public PedidoCompra() {
		this.situacaoPedido = StatusPedidoEnum.EM_DIGITACAO;
		this.valorFinal = BigDecimal.ZERO;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public LocalDate getDtPedido() {
		return dtPedido;
	}

	public void setDtPedido(LocalDate dtPedido) {
		this.dtPedido = dtPedido;
	}

	public StatusPedidoEnum getSituacaoPedido() {
		return situacaoPedido;
	}

	public void setSituacaoPedido(StatusPedidoEnum situacaoPedido) {
		this.situacaoPedido = situacaoPedido;
	}

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}

	public List<DescricaoPedido> getItens() {
		return itens;
	}

	public void setItens(List<DescricaoPedido> itens) {
		this.itens = itens;
	}
	
	
}
