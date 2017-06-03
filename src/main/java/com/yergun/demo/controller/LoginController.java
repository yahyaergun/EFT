package com.yergun.demo.controller;

import com.yergun.demo.model.Token;
import com.yergun.demo.model.Credentials;
import com.yergun.demo.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientResponseException;

import java.util.Optional;


import javax.validation.Valid;


@RestController
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Token> login(@RequestBody @Valid Credentials credentials, BindingResult bindingResult){

        LOGGER.info("Login request received with email:{}",credentials.getEmail());

        if(bindingResult.hasErrors()){
            LOGGER.info("Invalid login parameters request, email:{}",credentials.getEmail());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Token> tokenOpt = null;

        try{
            tokenOpt = loginService.login(credentials);
        } catch (RestClientResponseException e){
            LOGGER.info("Call to test-report api failed with status : {},  description : {}", e.getStatusText(), e.getResponseBodyAsString());
        }

        if(null != tokenOpt && !tokenOpt.isPresent()){
            LOGGER.info("Authentication failed, email:{}",credentials.getEmail());
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(tokenOpt.get(), HttpStatus.OK);
    }
}
