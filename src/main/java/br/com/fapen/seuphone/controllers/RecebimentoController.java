package br.com.fapen.seuphone.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.seuphone.forms.RecebimentoForm;
import br.com.fapen.seuphone.repositories.PedidoCompraRepository;
import br.com.fapen.seuphone.services.RecebimentoService;
import br.com.fapen.seuphone.validations.RecebimentoFormValidator;

@Controller
@RequestMapping(value = "/recebimento")
public class RecebimentoController {
	
	@Autowired
	private PedidoCompraRepository pedidoRep;
	
	@Autowired
	private RecebimentoService recebimentoService;
	
	@Autowired
	private RecebimentoFormValidator recebimentoValidator;
	
	@InitBinder("recebimentoForm")
	protected void init(WebDataBinder binder) {
		binder.setValidator(recebimentoValidator);
	}

	@GetMapping(value = "/novo", name = "novoRecebimento")
	public ModelAndView newReceivement(RecebimentoForm recebimentoForm) {
		ModelAndView mav = new ModelAndView("/recebimento/novo");
		mav.addObject(recebimentoForm);
		mav.addObject("listaPedidos", pedidoRep.findAllBySituacaoPedidoEmDigitacaoAndInativoFalse());
		
		return mav;
	}
	
	@PostMapping(value = "/recebimento-itens", name = "carregaItensRecebimento")
	public ModelAndView loadReceivementItems(RecebimentoForm recebimentoForm) {
		recebimentoService.carregarItensRecebimento(recebimentoForm);
		ModelAndView mav = new ModelAndView("/recebimento/recebimento-itens");
		mav.addObject(recebimentoForm);
		return mav;
	}
	
	@PostMapping(value = "/salvar", name = "salvarRecebimento")
	public ModelAndView createReceivement(@Valid RecebimentoForm recebimentoForm, 
			BindingResult resultadoValidacao, RedirectAttributes atributos) {
		
		if(resultadoValidacao.hasErrors()) {
			return newReceivement(recebimentoForm);
		}
		
		recebimentoService.salvarRecebimento(recebimentoForm);
		return new ModelAndView("/pedidos/listar");
	}
}
