package br.com.fapen.seuphone.controllers;

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

@RestController
@CrossOrigin	
@RequestMapping("/api/produtos")
public class ProdutoApiController {

	
	@Autowired
	private ProdutoRepository produtoRep;
	
	@CrossOrigin
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
	
	@PostMapping
	public ResponseEntity<Object> incluir(@Valid @RequestBody Produto produto) {
		produtoRep.save(produto);
		return new ResponseEntity<Object>(produto, HttpStatus.CREATED);
	}
}
