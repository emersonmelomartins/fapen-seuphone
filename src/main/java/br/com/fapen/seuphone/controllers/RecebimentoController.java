package br.com.fapen.seuphone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fapen.seuphone.forms.RecebimentoForm;
import br.com.fapen.seuphone.repositories.PedidoCompraRepository;
import br.com.fapen.seuphone.services.RecebimentoService;

@Controller
@RequestMapping(value = "/recebimento")
public class RecebimentoController {
	
	@Autowired
	private PedidoCompraRepository pedidoRep;
	
	@Autowired
	private RecebimentoService recebimentoSerivce;

	@GetMapping(value = "/novo", name = "novoRecebimento")
	public ModelAndView newReceivement(RecebimentoForm recebimentoForm) {
		ModelAndView mav = new ModelAndView("/recebimento/novo");
		mav.addObject(recebimentoForm);
		mav.addObject("listaPedidos", pedidoRep.findAll());
		
		return mav;
	}
	
	@PostMapping(value = "/recebimento-itens", name = "carregaItensRecebimento")
	public ModelAndView loadReceivementItems(RecebimentoForm recebimentoForm) {
		recebimentoSerivce.carregarItensRecebimento(recebimentoForm);
		ModelAndView mav = new ModelAndView("/recebimento/recebimento-itens");
		mav.addObject(recebimentoForm);
		return mav;
	}
}
