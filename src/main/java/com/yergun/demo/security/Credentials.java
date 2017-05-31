package com.yergun.demo.security;

/**
 * Created by yahyaergun on 29/05/2017.
 *
 * Seperate POJO for getting login requests via POST on merchants/user/login.
 */
public class Credentials {
    private String email;
    private String password;

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
