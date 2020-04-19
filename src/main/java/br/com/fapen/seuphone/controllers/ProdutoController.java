package br.com.fapen.seuphone.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.seuphone.models.Produto;
import br.com.fapen.seuphone.repositories.Paginacao;
import br.com.fapen.seuphone.repositories.ProdutoRepository;
import br.com.fapen.seuphone.validations.ProdutoValidator;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository repProduto;

	
	
	@Autowired
	private ProdutoValidator produtoValidator;

	@InitBinder("produto")
	protected void init(WebDataBinder binder) {
		binder.setValidator(produtoValidator);
	}
	
	

	@RequestMapping(value = "/produtos", method = RequestMethod.GET, name = "paginaProdutos")
	public ModelAndView listar(@RequestParam(defaultValue = "1") Integer pagina, @RequestParam(defaultValue = "") String busca) {
		
		Page<Produto> produtosCadastrados;
		if(busca.equals("")) {
			produtosCadastrados = repProduto.findAllByOrderByIdProdutoAsc(Paginacao.getPaginacao(pagina));
		} else {
			produtosCadastrados = repProduto.findByDescricaoContainingIgnoreCase(busca, Paginacao.getPaginacao(pagina));
		}

		ModelAndView mav = new ModelAndView("produto/lista");
		mav.addObject("produtos", produtosCadastrados);

		return mav;
	}

	@RequestMapping(value = "/produtos/novo", method = RequestMethod.GET, name = "novoProduto")
	public String novo(Produto produto) {
		return "/produto/novo";
	}
	
	@RequestMapping(value = "/produtos/{id}/editar", method = RequestMethod.GET, name = "alterarProduto")
	public ModelAndView editar(@PathVariable Long id) {
		
		Produto produto = repProduto.getOne(id);
		
		ModelAndView mav = new ModelAndView("produto/novo");
		mav.addObject("produto", produto);
		
		return mav;
	}
	

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, name = "salvarProduto")
	public String salvar(@Valid Produto produto, BindingResult resultadoValidacao, RedirectAttributes atributos) {
		
		if(resultadoValidacao.hasErrors()) {
			
			atributos.addFlashAttribute("mensagemStatus", "Ocorreu um erro!");
			return novo(produto);
		}
		
		
		repProduto.save(produto);
		atributos.addFlashAttribute("mensagemStatus", "Produto adicionado com sucesso!");
		return "redirect:/produtos";
	}
	
	@RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET, name = "visualizarProduto")
	public ModelAndView visualizar(@PathVariable Long id) {
		Produto produto = repProduto.getOne(id);
		
		ModelAndView mav = new ModelAndView("produto/visualizar");
		mav.addObject("produto", produto);
		
		return mav;
	}
	
	@RequestMapping(value = "/produtos/{id}/apagar", method = RequestMethod.GET, name = "apagarProduto")
	public String apagar(@PathVariable Long id, RedirectAttributes atributos) {
		Produto produto = repProduto.getOne(id);
		repProduto.delete(produto);
		
		atributos.addFlashAttribute("mensagemStatus", "Produto " + id + " apagado com sucesso!");
		return "redirect:/produtos";
	}
}
