package br.com.fapen.seuphone.forms;

import java.time.LocalDate;

public class NotaFiltroForm {

	private Long numeroNota;
	private LocalDate dataNfInicial;
	private LocalDate dataNfFinal;
	private LocalDate dataRecebInicial;
	private LocalDate dataRecebFinal;
	private Long numeroPedido;
	private String tipoFiltro;
	private Integer pagina;
	private boolean novoFiltro;
	
	public NotaFiltroForm() {
		this.pagina = 1;
		this.novoFiltro = false;
		this.tipoFiltro = "NF";
	}
	
	public Long getNumeroNota() {
		return numeroNota;
	}
	public void setNumeroNota(Long numeroNota) {
		this.numeroNota = numeroNota;
	}
	public LocalDate getDataNfInicial() {
		return dataNfInicial;
	}
	public void setDataNfInicial(LocalDate dataNfInicial) {
		this.dataNfInicial = dataNfInicial;
	}
	public LocalDate getDataNfFinal() {
		return dataNfFinal;
	}
	public void setDataNfFinal(LocalDate dataNfFinal) {
		this.dataNfFinal = dataNfFinal;
	}
	public LocalDate getDataRecebInicial() {
		return dataRecebInicial;
	}
	public void setDataRecebInicial(LocalDate dataRecebInicial) {
		this.dataRecebInicial = dataRecebInicial;
	}
	public LocalDate getDataRecebFinal() {
		return dataRecebFinal;
	}
	public void setDataRecebFinal(LocalDate dataRecebFinal) {
		this.dataRecebFinal = dataRecebFinal;
	}
	public Long getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(Long numeroPedido) {
		this.numeroPedido = numeroPedido;
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
	
	
	
}
