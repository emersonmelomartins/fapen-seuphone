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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.fapen.seuphone.enums.CondicaoPagtoEnum;
import br.com.fapen.seuphone.enums.StatusPedidoEnum;
import br.com.fapen.seuphone.enums.StatusPedidoVendaEnum;

@Entity(name = "tb_pedido_venda")
public class PedidoVenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido_venda")
	private Long idPedidoVenda;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "dt_pedido_venda")
	private LocalDate dtPedidoVenda;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "dt_entrega_venda")
	private LocalDate dtEntregaVenda;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "situacao_pedido_venda")
	private StatusPedidoVendaEnum situacaoPedidoVenda;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "condicao_pagamento")
	private CondicaoPagtoEnum condicaoPagamento;
	
	@Column(name = "valor_final")
	private BigDecimal valorFinal;
	
	@Column(name = "tempo_contrato")
	private Integer tempoContrato;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_login")
	private Usuario usuario;
	
	@Column(columnDefinition = "boolean default false")
	private boolean inativo;
	
	@OneToMany(mappedBy = "pedido_venda", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItensPedidoVenda> itens = new ArrayList<ItensPedidoVenda>();

	public Long getIdPedidoVenda() {
		return idPedidoVenda;
	}

	public void setIdPedidoVenda(Long idPedidoVenda) {
		this.idPedidoVenda = idPedidoVenda;
	}

	public LocalDate getDtPedidoVenda() {
		return dtPedidoVenda;
	}

	public void setDtPedidoVenda(LocalDate dtPedidoVenda) {
		this.dtPedidoVenda = dtPedidoVenda;
	}

	public LocalDate getDtEntregaVenda() {
		return dtEntregaVenda;
	}

	public void setDtEntregaVenda(LocalDate dtEntregaVenda) {
		this.dtEntregaVenda = dtEntregaVenda;
	}

	public StatusPedidoVendaEnum getSituacaoPedidoVenda() {
		return situacaoPedidoVenda;
	}

	public void setSituacaoPedidoVenda(StatusPedidoVendaEnum situacaoPedidoVenda) {
		this.situacaoPedidoVenda = situacaoPedidoVenda;
	}

	public CondicaoPagtoEnum getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(CondicaoPagtoEnum condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Integer getTempoContrato() {
		return tempoContrato;
	}

	public void setTempoContrato(Integer tempoContrato) {
		this.tempoContrato = tempoContrato;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isInativo() {
		return inativo;
	}

	public void setInativo(boolean inativo) {
		this.inativo = inativo;
	}

	public List<ItensPedidoVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItensPedidoVenda> itens) {
		this.itens = itens;
	}

	
	
	
}
