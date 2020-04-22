package br.com.fapen.seuphone.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fapen.seuphone.models.Fornecedor;


@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    public Page<Fornecedor> findByDescricaoContainingIgnoreCase(String busca, Pageable paginacao);

    public Page<Fornecedor> findAllByOrderByIdFornecedor(Pageable paginacao);
}
