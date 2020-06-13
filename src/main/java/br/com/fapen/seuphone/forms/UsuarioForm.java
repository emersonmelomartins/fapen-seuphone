package br.com.fapen.seuphone.forms;

import java.util.ArrayList;
import java.util.List;

import br.com.fapen.seuphone.models.Perfil;
import br.com.fapen.seuphone.models.Usuario;

public class UsuarioForm {
	
	private Usuario usuario;
	private String confirmaSenha;
	private boolean inclusao;
	private List<Perfil> listaPerfil = new ArrayList<Perfil>();

	public UsuarioForm() {
		this.inclusao = true;
	}
	
	public UsuarioForm(Usuario usuario) {
		this.usuario = usuario;
		this.inclusao = false;
		
		for(Perfil perfil: usuario.getAuthorities()) {
			this.listaPerfil.add(perfil);
		}
	}
	
	

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isInclusao() {
		return inclusao;
	}

	public void setInclusao(boolean inclusao) {
		this.inclusao = inclusao;
	}

	public List<Perfil> getListaPerfil() {
		return listaPerfil;
	}

	public void setListaPerfil(List<Perfil> listaPerfil) {
		this.listaPerfil = listaPerfil;
	}
	
	
}
