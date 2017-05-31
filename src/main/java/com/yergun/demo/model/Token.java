package com.yergun.demo.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by yahyaergun on 31/05/2017.
 */
@XmlRootElement
public class Token {

    private String token;
    private TokenStatus status;

    public Token(String token, TokenStatus status) {
        this.token = token;
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public TokenStatus getStatus() {
        return status;
    }

}
