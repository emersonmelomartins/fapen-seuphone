package br.com.fapen.seuphone.DTO;

import java.io.Serializable;

public class JwtResponseDTO implements Serializable {


    private static final long serialVersionUID = 2919347065961328375L;

    private String jwtToken;

    public JwtResponseDTO(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return this.jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
    
}
