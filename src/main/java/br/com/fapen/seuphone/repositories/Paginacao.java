package br.com.fapen.seuphone.repositories;

import org.springframework.data.domain.PageRequest;

public class Paginacao {

	public static final Integer REGISTROS_POR_PAGINA = 5;
	
	public static PageRequest getPaginacao(Integer pagina) {
		if (pagina > 0) {
			return PageRequest.of(pagina - 1, REGISTROS_POR_PAGINA);
		} else {
			return PageRequest.of(pagina, REGISTROS_POR_PAGINA);
		}
	}
}
