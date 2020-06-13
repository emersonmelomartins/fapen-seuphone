package br.com.fapen.seuphone.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fapen.seuphone.forms.PedidoCompraForm;
import br.com.fapen.seuphone.forms.PedidoFiltroForm;
import br.com.fapen.seuphone.models.DescricaoPedido;
import br.com.fapen.seuphone.models.NotaFiscal;
import br.com.fapen.seuphone.models.PedidoCompra;
import br.com.fapen.seuphone.repositories.NotaFiscalRepository;
import br.com.fapen.seuphone.repositories.Paginacao;
import br.com.fapen.seuphone.repositories.PedidoCompraRepository;

@Service
public class PedidoCompraService {

	
	@Autowired
	private PedidoCompraRepository pedidoRep;
	
	@Autowired
	private NotaFiscalRepository notaFiscalRep;
	
	
	public Page<PedidoCompra> listar(PageRequest paginacao) {
		return pedidoRep.findAll(paginacao);
	}
	
	public Page<PedidoCompra> listar(PedidoFiltroForm pedidoFiltroForm) {
		
		if(pedidoFiltroForm.isNovoFiltro()) {
			pedidoFiltroForm.setPagina(1);
		}
		Pageable paginacao = Paginacao.getPaginacao(pedidoFiltroForm.getPagina());
		
		if(pedidoFiltroForm.getTipoFiltro().equals("NP")) {
			if(pedidoFiltroForm.getNumeroPedido() != null) {
			return pedidoRep.findAllByIdPedido(pedidoFiltroForm.getNumeroPedido(), paginacao);
			} else {
				return pedidoRep.findAllByOrderByIdPedidoAsc(paginacao);
			}
		} else if(pedidoFiltroForm.getTipoFiltro().equals("ST")) {
			return pedidoRep.findAllBySituacaoPedidoAndInativoFalse(pedidoFiltroForm.getStatus(), paginacao);
		} else if(pedidoFiltroForm.getTipoFiltro().equals("DT")) {
			return pedidoRep.findAllByDtEntregaBetween(pedidoFiltroForm.getEntregaInicial(), pedidoFiltroForm.getEntregaFinal(), paginacao);
		} else {
			return pedidoRep.findAllByInativoFalse(paginacao);
		}
		
	
	}
	
	public void calcularTotal(PedidoCompra pedido) {
		BigDecimal total = BigDecimal.ZERO;
		for (DescricaoPedido item : pedido.getItens()) {
			BigDecimal qtde = new BigDecimal(item.getQuantidade());
			BigDecimal totalItem = item.getValor().multiply(qtde);
			total = total.add(totalItem);
		}
		pedido.setValorFinal(total);
	}
	
	public void salvar(PedidoCompraForm pedidoCompraForm) {
		pedidoCompraForm.getPedidoCompra().getItens().clear();
		for(DescricaoPedido item : pedidoCompraForm.getItensPedidoCompra()) {
			item.setPedido(pedidoCompraForm.getPedidoCompra());
			pedidoCompraForm.getPedidoCompra().getItens().add(item);
		}
		this.calcularTotal(pedidoCompraForm.getPedidoCompra());
		pedidoRep.save(pedidoCompraForm.getPedidoCompra());
	}
	
	public BigDecimal calculaQtdTotal(DescricaoPedido descricaoPed) {
		BigDecimal qtd = new BigDecimal(descricaoPed.getQuantidade());
		BigDecimal valor = descricaoPed.getValor();
		
		BigDecimal total = valor.multiply(qtd);
		return total;
	}
	
	public NotaFiscal findNotaFiscal(Long idPedido) {
		NotaFiscal notaFiscal = notaFiscalRep.findByPedidoIdPedido(idPedido);
		return notaFiscal;
	}
	
}
