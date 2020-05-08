package br.com.fapen.seuphone.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.fapen.seuphone.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	public Page<Pessoa> findAllByOrderByIdPessoaAsc(Pageable paginacao);
	
	public Page<Pessoa> findByNomeContainingIgnoreCase(String busca, Pageable paginacao);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "SELECT * FROM tb_pessoa WHERE inativo = false", nativeQuery = true)
	public List<Pessoa> findAllWhereInativo();
	
}
