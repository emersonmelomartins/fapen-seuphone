package br.com.fapen.seuphone.forms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.com.fapen.seuphone.models.PedidoCompra;

public class RecebimentoForm {
	
	private Long idRecebimento;
	private Long serieNotaFiscal;
	private Long numeroNotaFiscal;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dtNotaFiscal;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dtRecebimento;
	
	private PedidoCompra pedido;
	
	
	private List<DescricaoRecebimentoForm> itens = new ArrayList<DescricaoRecebimentoForm>();
	
	public RecebimentoForm() {
		this.dtRecebimento = LocalDate.now();
	}

	public Long getIdRecebimento() {
		return idRecebimento;
	}

	public void setIdRecebimento(Long idRecebimento) {
		this.idRecebimento = idRecebimento;
	}

	public Long getSerieNotaFiscal() {
		return serieNotaFiscal;
	}

	public void setSerieNotaFiscal(Long serieNotaFiscal) {
		this.serieNotaFiscal = serieNotaFiscal;
	}

	public Long getNumeroNotaFiscal() {
		return numeroNotaFiscal;
	}

	public void setNumeroNotaFiscal(Long numeroNotaFiscal) {
		this.numeroNotaFiscal = numeroNotaFiscal;
	}

	public LocalDate getDtNotaFiscal() {
		return dtNotaFiscal;
	}

	public void setDtNotaFiscal(LocalDate dtNotaFiscal) {
		this.dtNotaFiscal = dtNotaFiscal;
	}

	public LocalDate getDtRecebimento() {
		return dtRecebimento;
	}

	public void setDtRecebimento(LocalDate dtRecebimento) {
		this.dtRecebimento = dtRecebimento;
	}

	public PedidoCompra getPedido() {
		return pedido;
	}

	public void setPedido(PedidoCompra pedido) {
		this.pedido = pedido;
	}

	public List<DescricaoRecebimentoForm> getItens() {
		return itens;
	}

	public void setItens(List<DescricaoRecebimentoForm> itens) {
		this.itens = itens;
	}
	
	
}
