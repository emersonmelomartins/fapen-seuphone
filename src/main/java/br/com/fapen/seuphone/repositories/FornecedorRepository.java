package br.com.fapen.seuphone.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fapen.seuphone.models.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

	public Page<Fornecedor> findByRazaoSocialContainingIgnoreCase(String busca, Pageable paginacao);

	public Page<Fornecedor> findAllByOrderById(Pageable paginacao);

	public boolean existsByCnpj(String cnpj);

	public Fornecedor findByCnpj(String cnpj);
	
	public boolean existsByEmail(String email);
	
	public Fornecedor findByEmail(String email);
	
	Long findOneById(Long id);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "SELECT * FROM tb_fornecedor WHERE inativo = false", nativeQuery = true)
	public List<Fornecedor> findAllWhereInativo();
	
}
