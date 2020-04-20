package br.com.fapen.seuphone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fapen.seuphone.repositories.PerfilRepository;

@Controller
public class PerfilController {
	
	@Autowired
	private PerfilRepository perfilRep;

}
