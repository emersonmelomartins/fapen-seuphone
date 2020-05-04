package br.com.fapen.seuphone.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.seuphone.models.Produto;
import br.com.fapen.seuphone.repositories.FornecedorRepository;
import br.com.fapen.seuphone.repositories.Paginacao;
import br.com.fapen.seuphone.repositories.ProdutoRepository;
import br.com.fapen.seuphone.validations.ProdutoValidator;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRep;

	@Autowired
	private FornecedorRepository fornecedorRep;
	
	
	@Autowired
	private ProdutoValidator produtoValidator;

	@InitBinder("produto")
	protected void init(WebDataBinder binder) {
		binder.setValidator(produtoValidator);
	}
	
	

	@GetMapping(name = "listarProdutos")
	public ModelAndView listProduct(@RequestParam(defaultValue = "1") Integer pagina, @RequestParam(defaultValue = "") String busca) {
		
		Page<Produto> listaProdutos;
		if(busca.equals("")) {
			listaProdutos = produtoRep.findAllByOrderByIdProdutoAsc(Paginacao.getPaginacao(pagina));
		} else {
			listaProdutos = produtoRep.findByDescricaoContainingIgnoreCase(busca, Paginacao.getPaginacao(pagina));
		}

		ModelAndView mav = new ModelAndView("produto/listar");
		mav.addObject("listaPaginada", listaProdutos);

		return mav;
	}

	@GetMapping(value = "/novo", name = "novoProduto")
	public ModelAndView newProduct(Produto produto) {
		
		ModelAndView mav = new ModelAndView("/produto/novo");
		mav.addObject("listaFornecedores", fornecedorRep.findAll());
		return mav;
	}
	
	@PostMapping(value = "/salvar", name = "salvarProduto")
	public ModelAndView createProduct(@Valid Produto produto, BindingResult resultadoValidacao, RedirectAttributes atributos) {
		
		if(resultadoValidacao.hasErrors()) {

			
			return newProduct(produto);
		}
		
		produtoRep.save(produto);
		atributos.addFlashAttribute("mensagemStatus", "Produto salvo com sucesso!");
		
		return new ModelAndView("redirect:/produtos");
	}
	
	@GetMapping(value = "/{id}/editar", name = "editarProduto")
	public ModelAndView editProduct(@PathVariable Long id, Model model) {
		
		Produto produto = produtoRep.getOne(id);
		
		
		model.addAttribute(produto);
		
		return newProduct(produto);
	}
	
	@PostMapping(value = "/{id}/apagar", name = "apagarProduto")
	public String inativar(@PathVariable Long id, RedirectAttributes atributos) {
		Produto produto = produtoRep.getOne(id);
		produtoRep.delete(produto);
		
		atributos.addFlashAttribute("mensagemStatus", "Produto apagado com sucesso!");
		return "redirect:/produtos";
	}
	
	@GetMapping(value = "/{id}", name = "visualizarProduto")
	public ModelAndView viewProduct(@PathVariable Long id) {
		Produto produto = produtoRep.getOne(id);
		
		ModelAndView mav = new ModelAndView("produto/visualizar");
		mav.addObject("produto", produto);
		
		return mav;
	}
}