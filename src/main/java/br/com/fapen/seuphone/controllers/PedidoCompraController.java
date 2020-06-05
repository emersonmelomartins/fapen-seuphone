package br.com.fapen.seuphone.controllers;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.seuphone.enums.CondicaoPagtoEnum;
import br.com.fapen.seuphone.enums.StatusPedidoEnum;
import br.com.fapen.seuphone.forms.PedidoCompraForm;
import br.com.fapen.seuphone.models.DescricaoPedido;
import br.com.fapen.seuphone.models.PedidoCompra;
import br.com.fapen.seuphone.reports.PedidoCompraReport;
import br.com.fapen.seuphone.repositories.FornecedorRepository;
import br.com.fapen.seuphone.repositories.Paginacao;
import br.com.fapen.seuphone.repositories.PedidoCompraRepository;
import br.com.fapen.seuphone.repositories.ProdutoRepository;
import br.com.fapen.seuphone.services.PedidoCompraService;
import br.com.fapen.seuphone.validations.PedidoCompraFormValidator;

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
	
	@Autowired
	private PedidoCompraReport pedidoCompraReport;
	
	@Autowired
	private PedidoCompraFormValidator pedidoCompraFormValidator;
	
	@InitBinder("pedidoCompraForm")
	protected void init(WebDataBinder binder) {
		binder.setValidator(pedidoCompraFormValidator);
	}

	@GetMapping(name = "listarPedidos")
	public ModelAndView listOrders(@RequestParam(defaultValue = "1") Integer pagina,
			@RequestParam(defaultValue = "") String busca) {

		Page<PedidoCompra> pedidos = pedidoService.listar(busca, Paginacao.getPaginacao(pagina));

		ModelAndView mav = new ModelAndView("/pedidos/listar");

		mav.addObject("listaPaginada", pedidos);
		return mav;
	}

	@GetMapping(value = "/novo", name = "novoPedido")
	public ModelAndView newOrder(PedidoCompraForm pedidoCompraForm) {
		ModelAndView mav = new ModelAndView("/pedidos/novo");

		mav.addObject("listaFornecedores", fornecedorRep.findAll());
		mav.addObject("listaStatusPedido", StatusPedidoEnum.values());
		mav.addObject("listaCondicaoPagto", CondicaoPagtoEnum.values());
		mav.addObject("listaProdutos", produtoRep.findAllByInativoFalse());

		return mav;
	}

	@PostMapping(value = "/salvar", name = "salvarPedido")
	public ModelAndView salvarPedido(@Valid PedidoCompraForm pedidoCompraForm, BindingResult resultadoValidacao,
			RedirectAttributes atributos) {

		if (resultadoValidacao.hasErrors()) {

			return newOrder(pedidoCompraForm);
		}
		
		pedidoService.salvar(pedidoCompraForm);
		atributos.addFlashAttribute("mensagemStatus", "Pedido foi salvo com sucesso!");
		return new ModelAndView("redirect:/pedidos");
	}
	
	@PostMapping(value = "/novoItem", name = "novoItemPedido")
	public ModelAndView formularioItem(@ModelAttribute("pedidoCompraForm") PedidoCompraForm pedidoCompraForm) {
		pedidoCompraForm.getItensPedidoCompra().add(new DescricaoPedido());
		ModelAndView mav = new ModelAndView("/pedidos/form-item");
		mav.addObject("listaProdutos", produtoRep.findAllByInativoFalse());
		
		return mav;
	}
	
	@RequestMapping(value = "/deletaItem/{linha}", method = RequestMethod.POST)
	public ModelAndView deletaItem(@PathVariable int linha, PedidoCompraForm pedidoCompraForm) {
		pedidoCompraForm.getItensPedidoCompra().remove(linha);
		ModelAndView mav = new ModelAndView("/pedidos/form-item");
		mav.addObject("listaProdutos", produtoRep.findAllByInativoFalse());
		
		return mav;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, name = "visualizarPedido")
	public ModelAndView visualizarPedido(@PathVariable Long id) {
		
		PedidoCompra pedidoCompra = pedidoRep.getOne(id);
		PedidoCompraForm pedidoCompraForm = new PedidoCompraForm(pedidoCompra);
		
		ModelAndView mav = new ModelAndView("/pedidos/visualizar");
		mav.addObject("pedidoCompraForm", pedidoCompraForm);
		
		return mav;
	}
	
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.GET, name = "editarPedido")
	public ModelAndView alterarPedido(@PathVariable Long id) {
		
		PedidoCompra pedidoCompra = pedidoRep.getOne(id);
		PedidoCompraForm pedidoCompraForm = new PedidoCompraForm(pedidoCompra);

		ModelAndView mav = new ModelAndView("/pedidos/novo");
		mav.addObject("listaFornecedores", fornecedorRep.findAll());
		mav.addObject("listaCondicaoPagto", CondicaoPagtoEnum.values());
		mav.addObject("listaStatusPedido", StatusPedidoEnum.values());
		mav.addObject("listaProdutos", produtoRep.findAllByInativoFalse());
		mav.addObject("pedidoCompraForm", pedidoCompraForm);
		
		return mav;
	}
	
	@RequestMapping(value = "/{id}/excluir", method = RequestMethod.POST, name = "apagarPedido")
	public String excluirPedido(@PathVariable Long id, RedirectAttributes atributos) {
		PedidoCompra pedidoCompra = pedidoRep.getOne(id);
		
		pedidoRep.delete(pedidoCompra);
		
		atributos.addFlashAttribute("mensagemStatus", "Pedido deletado com sucesso!");
		return "redirect:/pedidos";
	}
	
	@GetMapping(value = "/{id}/pdf", name = "gerarPdfPedido", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> gerarPdf(@PathVariable Long id, HttpServletResponse response) {
		PedidoCompra pedido = pedidoRep.getOne(id);
		ByteArrayInputStream pdfEmMemoria = pedidoCompraReport.gerarPdf(pedido);
		InputStreamResource retorno = new InputStreamResource(pdfEmMemoria);
		
		response.setContentType("application/pdf");
	    response.setHeader("Content-disposition","attachment;filename=pedido_" + pedido.getIdPedido() + ".pdf");
	    
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(retorno);
	}
	

}
