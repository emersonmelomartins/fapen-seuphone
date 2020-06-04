package br.com.fapen.seuphone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fapen.seuphone.forms.DescricaoRecebimentoForm;
import br.com.fapen.seuphone.forms.RecebimentoForm;
import br.com.fapen.seuphone.models.DescricaoNotaFiscal;
import br.com.fapen.seuphone.models.DescricaoPedido;
import br.com.fapen.seuphone.models.NotaFiscal;
import br.com.fapen.seuphone.models.Produto;
import br.com.fapen.seuphone.repositories.NotaFiscalRepository;

@Service
public class RecebimentoService {
	
	@Autowired
	private PedidoCompraService pedidoService;
	
	@Autowired
	private NotaFiscalRepository notaFiscalRep;

	public void carregarItensRecebimento(RecebimentoForm recebimentoForm) {
		
		recebimentoForm.getItens().clear();
		
		if(recebimentoForm.getPedido() != null) {
			for(DescricaoPedido itemPedido: recebimentoForm.getPedido().getItens()) {
				DescricaoRecebimentoForm itemRecebimento = new DescricaoRecebimentoForm();
				itemRecebimento.setProduto(itemPedido.getProduto());
				itemRecebimento.setQuantidade(itemPedido.getQuantidade());
				itemRecebimento.setPrecoUnitario(itemPedido.getValor());
				itemRecebimento.setValorTotal(pedidoService.calculaQtdTotal(itemPedido));
				recebimentoForm.getItens().add(itemRecebimento);
				
			}
		}
	}
	
	public void salvarRecebimento(RecebimentoForm recebimentoForm) {
		NotaFiscal notaFiscal = new NotaFiscal();
		
		notaFiscal.setIdNotaFiscal(recebimentoForm.getIdRecebimento());
		notaFiscal.setSerieNotaFiscal(recebimentoForm.getSerieNotaFiscal());
		notaFiscal.setNumeroNotaFiscal(recebimentoForm.getNumeroNotaFiscal());
		notaFiscal.setDtNotaFiscal(recebimentoForm.getDtNotaFiscal());
		notaFiscal.setDtRecebimento(recebimentoForm.getDtRecebimento());
		notaFiscal.setPedido(recebimentoForm.getPedido());
		
		for(DescricaoRecebimentoForm itemReceb: recebimentoForm.getItens()) {
			DescricaoNotaFiscal itemNotaFiscal = new DescricaoNotaFiscal();
			
			itemNotaFiscal.setNotaFiscal(notaFiscal);
			itemNotaFiscal.setProduto(itemReceb.getProduto());
			itemNotaFiscal.setQuantidade(itemReceb.getQuantidade());
			itemNotaFiscal.setPrecoUnitario(itemReceb.getPrecoUnitario());
			itemNotaFiscal.setValorTotal(itemReceb.getValorTotal());
			
			notaFiscal.getItensNotaFiscal().add(itemNotaFiscal);
		}
		
		notaFiscalRep.save(notaFiscal);
		
		// Alterar pedido para recebido?
		
		for(DescricaoNotaFiscal itemNF: notaFiscal.getItensNotaFiscal()) {
			Produto produto = itemNF.getProduto();
			
			produto.setQuantidadeEstoque(produto.getQuantidadeEstoque()+itemNF.getQuantidade().intValue());
		}
		
	}
}
