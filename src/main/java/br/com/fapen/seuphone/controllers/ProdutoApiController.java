package br.com.fapen.seuphone.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
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
		List<Produto> produtos = produtoRep.findAll();
		
		
		for(Produto produto : produtos){
			if(!produto.getCaminhoFoto().isEmpty() || !produto.getCaminhoFoto().isBlank() || produto.getCaminhoFoto() != null) {
					
				System.out.println(produto.getCaminhoFoto());
				produto.setFotoEmString(arquivoService.ImageToString(produto.getCaminhoFoto()));				
			}
        }
		return produtos;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) throws IOException {
		Optional<Produto> prod = produtoRep.findById(id);
		
		String imagemEmString = arquivoService.ImageToString(prod.get().getCaminhoFoto());
		
		prod.get().setFotoEmString(imagemEmString);
		
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
