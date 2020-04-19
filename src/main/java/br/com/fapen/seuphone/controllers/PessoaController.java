package br.com.fapen.seuphone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fapen.seuphone.models.Pessoa;
import br.com.fapen.seuphone.repositories.Paginacao;
import br.com.fapen.seuphone.repositories.PessoaRepository;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRep;

	@GetMapping(name = "listarPessoas")
	public ModelAndView listPerson(@RequestParam(defaultValue = "1") Integer pagina,
			@RequestParam(defaultValue = "") String busca) {

		Page<Pessoa> listaPessoas;
		if (busca.equals("")) {
			listaPessoas = pessoaRep.findAllByOrderByIdPessoaAsc(Paginacao.getPaginacao(pagina));
		} else {
			listaPessoas = pessoaRep.findByNomeContainingIgnoreCase(busca, Paginacao.getPaginacao(pagina));
		}

		ModelAndView mav = new ModelAndView("pessoa/listar");
		mav.addObject("listaPaginada", listaPessoas);

		return mav;
	}

	@GetMapping(value = "/novo", name = "novaPessoa")
	public String newPerson() {

		return "pessoa/novo";
	}

	@PostMapping(value = "/salvar", name = "salvarPessoa")
	public String createPerson(Pessoa pessoa, RedirectAttributes atributos) {

		pessoaRep.save(pessoa);

		atributos.addFlashAttribute("nensagemStatus", "Pessoa salva com sucesso!");

		return "redirect:/pessoas";
	}

	@GetMapping(value = "/{id}/editar", name = "editarPessoa")
	public ModelAndView editPerson(@PathVariable Long id) {

		Pessoa pessoa = pessoaRep.getOne(id);

		ModelAndView mav = new ModelAndView("/pessoa/novo");
		mav.addObject("pessoa", pessoa);

		return mav;
	}

	@PostMapping(value = "/{id}/apagar", name = "apagarPessoa")
	public String deletePerson(@PathVariable Long id, RedirectAttributes atributos) {

		Pessoa pessoa = pessoaRep.getOne(id);
		pessoaRep.delete(pessoa);

		atributos.addFlashAttribute("mensagemStatus", "Pessoa apagada com sucesso!");

		return "redirect:/pessoas";
	}

	@GetMapping(value = "/{id}", name = "visualizarPessoa")
	public ModelAndView viewPerson(@PathVariable Long id) {
		Pessoa pessoa = pessoaRep.getOne(id);

		ModelAndView mav = new ModelAndView("/pessoa/visualizar");
		mav.addObject("pessoa", pessoa);

		return mav;
	}

}
