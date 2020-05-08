package br.com.fapen.seuphone.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fapen.seuphone.models.Endereco;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Transactional
	@Modifying(clearAutomatically = true)
    @Query(value = "SELECT * FROM tb_endereco WHERE inativo = false", nativeQuery = true)
	public List<Endereco> findAllWhereInativo();
   
}
