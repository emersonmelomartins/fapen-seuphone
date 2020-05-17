package br.com.fapen.seuphone.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fapen.seuphone.models.Produto;
import br.com.fapen.seuphone.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produto")
public class ProdutoApiController {

	
	@Autowired
	private ProdutoRepository produtoRep;
	
	@GetMapping
	public List<Produto> listar() {
		return produtoRep.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
		Optional<Produto> prod = produtoRep.findById(id);
		if(prod.isEmpty()) {
			return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Produto>(prod.get(), HttpStatus.OK);
	}
}
