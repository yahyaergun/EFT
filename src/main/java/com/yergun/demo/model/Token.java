package com.yergun.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by yahyaergun on 31/05/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Token {

    private String token;
    private String status;

    public void setToken(String token) {
        this.token = token;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public String getStatus() {
        return status;
    }
}
