package br.com.fapen.seuphone.services;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.fapen.seuphone.models.Fornecedor;
import br.com.fapen.seuphone.models.Perfil;
import br.com.fapen.seuphone.repositories.FornecedorRepository;
import br.com.fapen.seuphone.repositories.Paginacao;
import br.com.fapen.seuphone.repositories.UsuarioRepository;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository fornecedorRep;
	
	@Autowired
	private UsuarioRepository usuarioRep;

public Page<Fornecedor> listarFornecedores(String busca, Integer pagina, Principal principal) {
		
		Page<Fornecedor> listaFornecedores;
		boolean isAdmin = false;
		
		for(Perfil p: usuarioRep.findByLogin(principal.getName()).getAuthorities()) {
			if(p.getAuthority().equals("ROLE_ADMIN")) {
				isAdmin = true;
			}
		}
		
		if(isAdmin) {
			if (busca.equals("")) {
				return listaFornecedores = fornecedorRep.findAllByOrderById(Paginacao.getPaginacao(pagina));
			} else {
				return listaFornecedores = fornecedorRep.findByRazaoSocialContainingIgnoreCase(busca, Paginacao.getPaginacao(pagina));
			}
		}
		
		if (busca.equals("")) {
			return listaFornecedores = fornecedorRep.findByInativoFalseOrderByIdAsc(Paginacao.getPaginacao(pagina));
		} else {
			return listaFornecedores = fornecedorRep.findByRazaoSocialContainingIgnoreCaseAndInativoFalse(busca, Paginacao.getPaginacao(pagina));
		}

		
	}
}
