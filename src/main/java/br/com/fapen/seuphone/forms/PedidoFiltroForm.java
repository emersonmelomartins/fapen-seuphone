package br.com.fapen.seuphone.forms;

import java.time.LocalDate;

import br.com.fapen.seuphone.enums.StatusPedidoEnum;

public class PedidoFiltroForm {

	private Long numeroPedido;
	private StatusPedidoEnum status;
	private LocalDate entregaInicial;
	private LocalDate entregaFinal;
	private String fornecedor;
	private String tipoFiltro;
	private Integer pagina;
	private boolean novoFiltro;

	public PedidoFiltroForm() {
		this.pagina = 1;
		this.novoFiltro = false;
		this.tipoFiltro = "NP";
	}

	public Long getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public StatusPedidoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusPedidoEnum status) {
		this.status = status;
	}

	public LocalDate getEntregaInicial() {
		return entregaInicial;
	}

	public void setEntregaInicial(LocalDate entregaInicial) {
		this.entregaInicial = entregaInicial;
	}

	public LocalDate getEntregaFinal() {
		return entregaFinal;
	}

	public void setEntregaFinal(LocalDate entregaFinal) {
		this.entregaFinal = entregaFinal;
	}

	public String getTipoFiltro() {
		return tipoFiltro;
	}

	public void setTipoFiltro(String tipoFiltro) {
		this.tipoFiltro = tipoFiltro;
	}

	public Integer getPagina() {
		return pagina;
	}

	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}

	public boolean isNovoFiltro() {
		return novoFiltro;
	}

	public void setNovoFiltro(boolean novoFiltro) {
		this.novoFiltro = novoFiltro;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

}
