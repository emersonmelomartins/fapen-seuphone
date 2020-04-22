package br.com.fapen.seuphone.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity(name = "tb_perfil")
public class Perfil implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_perfil", length = 45, unique = true)
	private String authority;

	private String descricao;

	public Perfil() {
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Perfil(String authority, String descricao) {
		this.authority = authority;
		this.descricao = descricao;
	}

	@Override
	public String getAuthority() {
		return this.authority;
	}

}
