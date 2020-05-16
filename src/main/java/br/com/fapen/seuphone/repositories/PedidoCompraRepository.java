package br.com.fapen.seuphone.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fapen.seuphone.models.PedidoCompra;

public interface PedidoCompraRepository extends JpaRepository<PedidoCompra, Long> {

	public Page<PedidoCompra> findAllByIdPedidoContainingIgnoreCase(String id, Pageable paginacao);

	public Page<PedidoCompra> findAllByOrderByIdPedidoAsc(Pageable paginacao);
}
