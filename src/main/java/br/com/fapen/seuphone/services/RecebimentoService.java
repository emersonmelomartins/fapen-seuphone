package br.com.fapen.seuphone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fapen.seuphone.forms.DescricaoRecebimentoForm;
import br.com.fapen.seuphone.forms.RecebimentoForm;
import br.com.fapen.seuphone.models.DescricaoPedido;

@Service
public class RecebimentoService {
	
	@Autowired
	private PedidoCompraService pedidoService;

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
}
