package com.yergun.demo.model;

import org.hibernate.validator.constraints.NotBlank;

public class Credentials {

    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public Credentials() {}

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
