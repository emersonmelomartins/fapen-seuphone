package br.com.fapen.seuphone.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fapen.seuphone.models.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, String> {

	public Page<Perfil> findAllByOrderByAuthorityAsc(Pageable paginacao);
	
	public Page<Perfil> findByAuthorityContainingIgnoreCase(String busca, Pageable paginacao);
}
