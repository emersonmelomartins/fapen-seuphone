package br.com.fapen.seuphone.DTO;

import org.springframework.http.HttpStatus;

public class ResponseRecoverPasswordDTO {

	private String message;
	private HttpStatus status;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
