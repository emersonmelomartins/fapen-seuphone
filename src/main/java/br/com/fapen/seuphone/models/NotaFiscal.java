package br.com.fapen.seuphone.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity(name = "tb_nota_fiscal")
public class NotaFiscal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_nota_fiscal")
	private Long idNotaFiscal;
	
	@Column(name = "serie_nota_fiscal")
	private Long serieNotaFiscal;
	
	@Column(name = "numero_nota_fiscal")
	private Long numeroNotaFiscal;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dtNotaFiscal;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dtRecebimento;
	
	@ManyToOne
	private PedidoCompra pedido;
	
	@OneToMany(mappedBy = "notaFiscal", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DescricaoNotaFiscal> itensNotaFiscal = new ArrayList<DescricaoNotaFiscal>();

	public Long getIdNotaFiscal() {
		return idNotaFiscal;
	}

	public void setIdNotaFiscal(Long idNotaFiscal) {
		this.idNotaFiscal = idNotaFiscal;
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

	public List<DescricaoNotaFiscal> getItensNotaFiscal() {
		return itensNotaFiscal;
	}

	public void setItensNotaFiscal(List<DescricaoNotaFiscal> itensNotaFiscal) {
		this.itensNotaFiscal = itensNotaFiscal;
	}
	
	
	
}
