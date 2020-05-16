package br.com.fapen.seuphone.repositories;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fapen.seuphone.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByLogin(String login);

	public Page<Usuario> findAllByOrderByIdLoginAsc(Pageable paginacao);

	public Page<Usuario> findByLoginContainingIgnoreCase(String busca, Pageable paginacao);
	
	public boolean existsByPessoaCpf(String cpf);
	
	public boolean existsByEmail(String email);
	
	public Usuario findByEmail(String email);
	
	public Usuario findByPessoaCpf(String cpf);
	
	public boolean existsByLogin(String login);

	Usuario findOneByIdLogin(Long id);

	public Page<Usuario> findByInativoFalse(Pageable paginacao);
	
	public Usuario findByHash(String hash);
	
	public boolean existsByHash(String hash);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE tb_login SET hash = :novoHash WHERE id_login = :id", nativeQuery = true)
	public void alterarHash(@Param("novoHash") String novoHash, @Param("id") Long id);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE tb_login SET senha = :senha WHERE id_login = :id", nativeQuery = true)
	public void alterarSenha(@Param("senha") String novaSenha, @Param("id") Long id);
}
