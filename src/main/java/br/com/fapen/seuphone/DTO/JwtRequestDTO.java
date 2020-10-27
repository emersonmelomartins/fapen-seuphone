package br.com.fapen.seuphone.DTO;

import java.io.Serializable;

public class JwtRequestDTO implements Serializable {


    private static final long serialVersionUID = 9050212712100211028L;

    private String username;
    private String password;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
