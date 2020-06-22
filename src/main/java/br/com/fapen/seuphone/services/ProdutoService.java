package br.com.fapen.seuphone.services;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.fapen.seuphone.models.Perfil;
import br.com.fapen.seuphone.models.Produto;
import br.com.fapen.seuphone.repositories.Paginacao;
import br.com.fapen.seuphone.repositories.ProdutoRepository;
import br.com.fapen.seuphone.repositories.UsuarioRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRep;

    @Autowired
    private UsuarioRepository usuarioRep;

    public Page<Produto> listar (String busca, Integer pagina, Principal principal) {

        Page<Produto> listaProdutos;
        boolean isAdmin = false;
		
		for(Perfil p: usuarioRep.findByLogin(principal.getName()).getAuthorities()) {
			if(p.getAuthority().equals("ROLE_ADMIN")) {
				isAdmin = true;
			}
		}

        if(isAdmin){
            if(busca.equals("")) {
               return listaProdutos = produtoRep.findAllByOrderByIdProdutoAsc(Paginacao.getPaginacao(pagina));
            } else {
               return listaProdutos = produtoRep.findByDescricaoContainingIgnoreCase(busca, Paginacao.getPaginacao(pagina));
            }
        }

        if(busca.equals("")) {
            return listaProdutos = produtoRep.findByInativoFalse(Paginacao.getPaginacao(pagina));
         } else {
            return listaProdutos = produtoRep.findByDescricaoContainingIgnoreCaseAndInativoFalse(busca, Paginacao.getPaginacao(pagina));
         } 
    }
    
}