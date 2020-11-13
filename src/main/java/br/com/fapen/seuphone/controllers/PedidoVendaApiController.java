package br.com.fapen.seuphone.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.seuphone.forms.PedidoCompraForm;
import br.com.fapen.seuphone.forms.PedidoVendaForm;
import br.com.fapen.seuphone.models.DescricaoNotaFiscal;
import br.com.fapen.seuphone.models.ItensPedidoVenda;
import br.com.fapen.seuphone.models.PedidoCompra;
import br.com.fapen.seuphone.models.PedidoVenda;
import br.com.fapen.seuphone.models.Produto;
import br.com.fapen.seuphone.models.Usuario;
import br.com.fapen.seuphone.repositories.PedidoCompraRepository;
import br.com.fapen.seuphone.repositories.PedidoVendaRepository;
import br.com.fapen.seuphone.repositories.ProdutoRepository;
import br.com.fapen.seuphone.repositories.UsuarioRepository;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/pedidos")
public class PedidoVendaApiController {

	@Autowired
	private PedidoVendaRepository pedidoRep;

	@Autowired
	private UsuarioRepository usuarioRep;
	
	@Autowired
	private ProdutoRepository produtoRep;

	@PostMapping
	public ResponseEntity<Object> salvarPedidoVenda(@RequestBody PedidoVendaForm pedidoVendaForm,
			BindingResult resultadoValidacao, RedirectAttributes atributos) {

		
		Usuario usuario = usuarioRep.findByLogin(pedidoVendaForm.getPedidoVenda().getUsuario().getLogin());

		for (ItensPedidoVenda item : pedidoVendaForm.getItensPedidoVenda()) {
			item.setPedido_venda(pedidoVendaForm.getPedidoVenda());
			pedidoVendaForm.getPedidoVenda().getItens().add(item);

		}
		BigDecimal total = BigDecimal.ZERO;
		for (ItensPedidoVenda item : pedidoVendaForm.getPedidoVenda().getItens()) {
			BigDecimal qtde = new BigDecimal(item.getQuantidade());
			BigDecimal totalItem = item.getValor().multiply(qtde);
			total = total.add(totalItem);
		}
		
		pedidoVendaForm.getPedidoVenda().setUsuario(usuario);
		pedidoVendaForm.getPedidoVenda().setValorFinal(total);
		
		pedidoRep.save(pedidoVendaForm.getPedidoVenda());
		
		for (ItensPedidoVenda item : pedidoVendaForm.getPedidoVenda().getItens()) {
			Produto produto = item.getProduto();

			produto.setFotoEmString("");
			produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - item.getQuantidade().intValue());

			//System.out.println(item.getQuantidade().intValue());
			produtoRep.save(produto);

		}

		return new ResponseEntity<Object>(pedidoVendaForm, HttpStatus.ACCEPTED);

	}
	
	@CrossOrigin
	@GetMapping("/{login}")
	public List<PedidoVenda> listarPedidoPorLogin(@PathVariable String login) throws IOException {
		
		Usuario usuario = usuarioRep.findByLogin(login);
		
		List<PedidoVenda> pedidos = pedidoRep.findAllByUsuario(usuario);
		


		return pedidos;
	}
	
	

}
