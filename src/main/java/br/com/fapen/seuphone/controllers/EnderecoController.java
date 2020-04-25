package br.com.fapen.seuphone.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.seuphone.models.Endereco;
import br.com.fapen.seuphone.repositories.EnderecoRepository;

@Controller
public class EnderecoController {

    @Autowired
    public EnderecoRepository enderecoRepository;

    @RequestMapping(value = "/enderecos/novo", method = RequestMethod.GET, name = "novoEndereco")
	public String novo(Endereco endereco) {
		return "/endereco/novo";
	}

    @RequestMapping(value = "/salvar", method = RequestMethod.POST, name = "salvarEndereco")
	public String salvar(@Valid Endereco endereco, BindingResult resultadoValidacao, RedirectAttributes atributos) {
		
		if(resultadoValidacao.hasErrors()) {
			
			atributos.addFlashAttribute("mensagemStatus", "Ocorreu um erro!");
			return novo(endereco);
		}
		
		
		enderecoRepository.save(endereco);
		atributos.addFlashAttribute("mensagemStatus", "Endereço adicionado com sucesso!");
		return "redirect:/enderecos";
	}

	@RequestMapping(value = "/enderecos/{id}", method = RequestMethod.GET, name = "visualizarEndereco")
	public ModelAndView visualizar(@PathVariable Long id) {
		Endereco endereco = enderecoRepository.getOne(id);
		
		ModelAndView mav = new ModelAndView("endereco/visualizar");
		mav.addObject("endereco", endereco);
		
		return mav;
	}

	@RequestMapping(value = "/enderecos/{id}/apagar", method = RequestMethod.GET, name = "apagarEndereco")
	public String apagar(@PathVariable Long id, RedirectAttributes atributos) {
		Endereco endereco = enderecoRepository.getOne(id);
		enderecoRepository.delete(endereco);
		
		atributos.addFlashAttribute("mensagemStatus", "endereco " + id + " apagado com sucesso!");
		return "redirect:/enderecos";
	}

	@RequestMapping(value = "/enderecos/{id}/editar", method = RequestMethod.GET, name = "alterarEndereco")
	public ModelAndView editar(@PathVariable Long id) {
		
		Endereco endereco = enderecoRepository.getOne(id);
		
		ModelAndView mav = new ModelAndView("endereco/novo");
		mav.addObject("endereco", endereco);
		
		return mav;
	}

}