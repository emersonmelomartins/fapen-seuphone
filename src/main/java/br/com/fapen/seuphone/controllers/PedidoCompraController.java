package br.com.fapen.seuphone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.fapen.seuphone.models.PedidoCompra;
import br.com.fapen.seuphone.repositories.FornecedorRepository;
import br.com.fapen.seuphone.repositories.Paginacao;
import br.com.fapen.seuphone.repositories.PedidoCompraRepository;
import br.com.fapen.seuphone.repositories.ProdutoRepository;
import br.com.fapen.seuphone.services.PedidoCompraService;

@Controller
@RequestMapping("/pedidos")
public class PedidoCompraController {

	@Autowired
	private PedidoCompraRepository pedidoRep;

	@Autowired
	private FornecedorRepository fornecedorRep;

	@Autowired
	private ProdutoRepository produtoRep;
	
	@Autowired
	private PedidoCompraService pedidoService;

	@GetMapping(name = "listarPedidos")
	public ModelAndView listarPedidos(@RequestParam(defaultValue = "1") Integer pagina,
			@RequestParam(defaultValue = "") String busca) {
		
	
		Page<PedidoCompra> pedidos = pedidoService.listar(busca, Paginacao.getPaginacao(pagina));

		ModelAndView mav = new ModelAndView("/pedidos/listar");

		mav.addObject("listaPaginada", pedidos);
		return mav;
	}

}
