package br.com.fapen.seuphone.forms;

import java.util.ArrayList;
import java.util.List;

import br.com.fapen.seuphone.models.DescricaoPedido;
import br.com.fapen.seuphone.models.PedidoCompra;

public class PedidoCompraForm {

	
	private PedidoCompra pedidoCompra;
	private List<DescricaoPedido> itensPedidoCompra = new ArrayList<DescricaoPedido>();
	
	public PedidoCompraForm() {
		
	}
	
	public PedidoCompraForm(PedidoCompra pedido) {
		this.pedidoCompra = pedido;
		this.itensPedidoCompra = pedido.getItens();
	}

	public PedidoCompra getPedidoCompra() {
		return pedidoCompra;
	}

	public void setPedidoCompra(PedidoCompra pedidoCompra) {
		this.pedidoCompra = pedidoCompra;
	}

	public List<DescricaoPedido> getItensPedidoCompra() {
		return itensPedidoCompra;
	}

	public void setItensPedidoCompra(List<DescricaoPedido> itensPedidoCompra) {
		this.itensPedidoCompra = itensPedidoCompra;
	}
	
	
}
