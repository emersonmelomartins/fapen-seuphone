package br.com.fapen.seuphone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/painel")
public class PainelController {

	@RequestMapping(method = RequestMethod.GET, name = "paginaPainel")
	public String painel() {
		return "painel";
	}
}
