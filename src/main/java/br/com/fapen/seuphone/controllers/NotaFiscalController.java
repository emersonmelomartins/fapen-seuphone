package br.com.fapen.seuphone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.fapen.seuphone.models.NotaFiscal;
import br.com.fapen.seuphone.repositories.NotaFiscalRepository;
import br.com.fapen.seuphone.repositories.Paginacao;

@Controller
@RequestMapping("/notas-fiscais")
public class NotaFiscalController {
	
	@Autowired
	private NotaFiscalRepository notaFiscalRepository;

	
	 @GetMapping(name = "listarNotasFiscais")
		public ModelAndView listInvoices(@RequestParam(defaultValue = "1") Integer pagina, @RequestParam(defaultValue = "") String busca) {
			
			Page<NotaFiscal> notasFiscaisCadastradas;
			if(busca.equals("")) {
				notasFiscaisCadastradas = notaFiscalRepository.findAll(Paginacao.getPaginacao(pagina));
			} else {
				notasFiscaisCadastradas = notaFiscalRepository.findByPedidoIdPedidoContainingIgnoreCase(busca, Paginacao.getPaginacao(pagina));
			}

			ModelAndView mav = new ModelAndView("nota-fiscal/listar");
			mav.addObject("listaPaginada", notasFiscaisCadastradas);

			return mav;
		}
}
