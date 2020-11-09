package br.com.fapen.seuphone.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fapen.seuphone.models.Produto;
import br.com.fapen.seuphone.repositories.ProdutoRepository;
import br.com.fapen.seuphone.services.ArquivoService;

@RestController
@CrossOrigin
@RequestMapping("/api/produtos")
public class ProdutoApiController {

	@Autowired
	private ProdutoRepository produtoRep;

	@Autowired
	private ArquivoService arquivoService;

	@CrossOrigin
	@GetMapping
	public List<Produto> listar() throws IOException {
		List<Produto> produtos = produtoRep.findAllByInativoFalse();

		for (Produto produto : produtos) {
			if (produto.getCaminhoFoto() != null) {
				produto.setFotoEmString(
						"data:image/png;base64," + arquivoService.ImageToString(produto.getCaminhoFoto()));
			} else {
				produto.setFotoEmString("");
			}
		}
		return produtos;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) throws IOException {
		Optional<Produto> prod = produtoRep.findById(id);

		if (prod.isEmpty()) {
			return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
		}

		if (prod.get().getCaminhoFoto() != null) {
			prod.get().setFotoEmString(
					"data:image/png;base64," + arquivoService.ImageToString(prod.get().getCaminhoFoto()));
		} else {
			prod.get().setFotoEmString("");
		}
		return new ResponseEntity<Produto>(prod.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> incluir(@Valid @RequestBody Produto produto) {
		produtoRep.save(produto);
		return new ResponseEntity<Object>(produto, HttpStatus.CREATED);
	}
}
