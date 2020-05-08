package br.com.fapen.seuphone.forms;

import br.com.fapen.seuphone.models.Usuario;

public class RecuperarSenhaForm {
	
	private Usuario usuario;
	private String novoPassword;
	private String confirmarPassword;

	public RecuperarSenhaForm(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNovoPassword() {
		return novoPassword;
	}

	public void setNovoPassword(String novoPassword) {
		this.novoPassword = novoPassword;
	}

	public String getConfirmarPassword() {
		return confirmarPassword;
	}

	public void setConfirmarPassword(String confirmarPassword) {
		this.confirmarPassword = confirmarPassword;
	}
	
	
}
