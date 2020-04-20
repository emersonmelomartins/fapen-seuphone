package br.com.fapen.seuphone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fapen.seuphone.models.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, String> {

}
