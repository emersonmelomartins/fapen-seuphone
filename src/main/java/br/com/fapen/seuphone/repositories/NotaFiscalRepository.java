package br.com.fapen.seuphone.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fapen.seuphone.models.NotaFiscal;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long>{

	public Page<NotaFiscal> findByPedidoIdPedidoContainingIgnoreCase(String busca, Pageable paginacao);
}
