package br.com.fapen.seuphone.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.seuphone.models.Fornecedor;
import br.com.fapen.seuphone.repositories.FornecedorRepository;
import br.com.fapen.seuphone.repositories.Paginacao;

public class FornecedorController {

    @Autowired
    public FornecedorRepository fornecedorRepository;

    @RequestMapping(value = "/fornecedores", method = RequestMethod.GET, name = "paginaFornecedores")
	public ModelAndView listar(@RequestParam(defaultValue = "1") Integer pagina, @RequestParam(defaultValue = "") String busca) {
		
		Page<Fornecedor> fornecedoresCadastrados;
		if(busca.equals("")) {
			fornecedoresCadastrados = fornecedorRepository.findAllByOrderByIdFornecedor(Paginacao.getPaginacao(pagina));
		} else {
			fornecedoresCadastrados = fornecedorRepository.findByDescricaoContainingIgnoreCase(busca, Paginacao.getPaginacao(pagina));
		}

		ModelAndView mav = new ModelAndView("fornecedor/lista");
		mav.addObject("fornecedores", fornecedoresCadastrados);

		return mav;
	}

	@RequestMapping(value = "/fornecedores/novo", method = RequestMethod.GET, name = "novoFornecedor")
	public String novo(Fornecedor fornecedor) {
		return "/fornecedor/novo";
	}
	
	@RequestMapping(value = "/fornecedores/{id}/editar", method = RequestMethod.GET, name = "alterarFornecedor")
	public ModelAndView editar(@PathVariable Long id) {
		
		Fornecedor fornecedor = fornecedorRepository.getOne(id);
		
		ModelAndView mav = new ModelAndView("fornecedor/novo");
		mav.addObject("fornecedor", fornecedor);
		
		return mav;
	}
	

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, name = "salvarFornecedor")
	public String salvar(@Valid Fornecedor fornecedor, BindingResult resultadoValidacao, RedirectAttributes atributos) {
		
		if(resultadoValidacao.hasErrors()) {
			
			atributos.addFlashAttribute("mensagemStatus", "Ocorreu um erro!");
			return novo(fornecedor);
		}
		
		
		fornecedorRepository.save(fornecedor);
		atributos.addFlashAttribute("mensagemStatus", "fornecedor adicionado com sucesso!");
		return "redirect:/fornecedores";
	}
	
	@RequestMapping(value = "/fornecedores/{id}", method = RequestMethod.GET, name = "visualizarFornecedor")
	public ModelAndView visualizar(@PathVariable Long id) {
		Fornecedor fornecedor = fornecedorRepository.getOne(id);
		
		ModelAndView mav = new ModelAndView("fornecedor/visualizar");
		mav.addObject("fornecedor", fornecedor);
		
		return mav;
	}
	
	@RequestMapping(value = "/fornecedores/{id}/apagar", method = RequestMethod.GET, name = "apagarFornecedor")
	public String apagar(@PathVariable Long id, RedirectAttributes atributos) {
		Fornecedor fornecedor = fornecedorRepository.getOne(id);
		fornecedorRepository.delete(fornecedor);
		
		atributos.addFlashAttribute("mensagemStatus", "fornecedor " + id + " apagado com sucesso!");
		return "redirect:/fornecedores";
	}
}