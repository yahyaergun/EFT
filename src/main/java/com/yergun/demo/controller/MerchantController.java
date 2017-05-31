package com.yergun.demo.controller;

import com.yergun.demo.model.Token;
import com.yergun.demo.security.Credentials;
import com.yergun.demo.security.TokenAuthService;
import com.yergun.demo.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v3")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @RequestMapping(value = "/merchants/user/login", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Token> login(@RequestBody Credentials credentials){
        if(merchantService.authenticate(credentials.getEmail(), credentials.getPassword())){
            Token token = new Token(TokenAuthService.getTokenString(credentials.getEmail()), Token.TokenStatus.APPROVED);
            return new ResponseEntity<Token>(token, HttpStatus.OK);
        }

        return new ResponseEntity<Token>(HttpStatus.UNAUTHORIZED);
    }
}
