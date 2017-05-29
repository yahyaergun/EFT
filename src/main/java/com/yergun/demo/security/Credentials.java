package com.yergun.demo.security;

/**
 * Created by yahyaergun on 29/05/2017.
 *
 * Seperate POJO for getting login requests via POST /login.
 */
public class Credentials {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
