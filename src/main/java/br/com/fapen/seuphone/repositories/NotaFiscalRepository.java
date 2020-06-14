package br.com.fapen.seuphone.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fapen.seuphone.models.NotaFiscal;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long>{

	public Page<NotaFiscal> findByPedidoIdPedidoContainingIgnoreCase(String busca, Pageable paginacao);
	
	public NotaFiscal findByPedidoIdPedido(Long id);
	
	public Page<NotaFiscal> findByNumeroNotaFiscal(Long notaFiscal, Pageable paginacao);
	
	public Page<NotaFiscal> findByPedidoIdPedido(Long idPedido, Pageable paginacao);
	
	public Page<NotaFiscal> findAllByDtNotaFiscalBetween(LocalDate dtInicial, LocalDate dtFinal, Pageable paginacao);
	
	public Page<NotaFiscal> findAllByDtRecebimentoBetween(LocalDate dtInicial, LocalDate dtFinal, Pageable paginacao);
	
	public Page<NotaFiscal> findAll(Pageable paginacao);
}
