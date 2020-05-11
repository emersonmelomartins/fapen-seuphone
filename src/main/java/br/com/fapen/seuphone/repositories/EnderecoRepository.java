package br.com.fapen.seuphone.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.com.fapen.seuphone.models.Endereco;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
