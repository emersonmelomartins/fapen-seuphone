package br.com.fapen.seuphone.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fapen.seuphone.models.Pessoa;
import br.com.fapen.seuphone.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByLogin(String login);

	public Page<Usuario> findAllByOrderByIdLoginAsc(Pageable paginacao);

	public Page<Usuario> findByLoginContainingIgnoreCase(String busca, Pageable paginacao);
	
	public boolean existsByPessoaCpf(String cpf);
	
	public Usuario findByPessoaCpf(String cpf);
}
