package br.com.fapen.seuphone.DTO;

import java.io.Serializable;

public class Base64ImageRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userLogin;
	private String base64Image;
	
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
