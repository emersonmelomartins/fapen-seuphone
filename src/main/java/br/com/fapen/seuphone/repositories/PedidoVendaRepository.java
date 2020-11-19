package br.com.fapen.seuphone.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fapen.seuphone.models.PedidoVenda;
import br.com.fapen.seuphone.models.Usuario;

public interface PedidoVendaRepository extends JpaRepository<PedidoVenda, Long> {

	public List<PedidoVenda> findAllByUsuario(Usuario usuario);
}
