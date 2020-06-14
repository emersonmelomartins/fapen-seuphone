package br.com.fapen.seuphone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fapen.seuphone.forms.NotaFiltroForm;
import br.com.fapen.seuphone.models.NotaFiscal;
import br.com.fapen.seuphone.repositories.NotaFiscalRepository;
import br.com.fapen.seuphone.services.NotaFiscalService;

@Controller
@RequestMapping("/notas-fiscais")
public class NotaFiscalController {

	@Autowired
	private NotaFiscalRepository notaFiscalRep;
	
	@Autowired
	private NotaFiscalService notaFiscalService;
	

	@GetMapping(name = "listarNotasFiscais")
		public ModelAndView listInvoices(NotaFiltroForm notaFiltroForm) {
			
			Page<NotaFiscal> notasFiscaisCadastradas = notaFiscalService.listar(notaFiltroForm);
			
			ModelAndView mav = new ModelAndView("nota-fiscal/listar");
			mav.addObject("notaFiltroForm", notaFiltroForm);
			mav.addObject("listaPaginada", notasFiscaisCadastradas);

			return mav;
		}

	@GetMapping(value = "/{id}", name = "visualizarNotaFiscal")
	public ModelAndView viewInvoice(@PathVariable Long id) {

		NotaFiscal notaFiscal = notaFiscalRep.getOne(id);

		ModelAndView mav = new ModelAndView("/nota-fiscal/visualizar");
		mav.addObject("notaFiscal", notaFiscal);

		return mav;
	}
}
