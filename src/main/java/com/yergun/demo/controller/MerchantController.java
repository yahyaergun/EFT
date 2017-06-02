package com.yergun.demo.controller;

import com.yergun.demo.model.Token;
import com.yergun.demo.model.Credentials;
import com.yergun.demo.service.MerchantService;
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
public class MerchantController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MerchantController.class);

    @Autowired
    private MerchantService merchantService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Token> login(@RequestBody @Valid Credentials credentials, BindingResult bindingResult){

        LOGGER.info("Login request received with email:{}",credentials.getEmail());

        if(bindingResult.hasErrors()){
            LOGGER.info("Invalid login parameters request, email:{}",credentials.getEmail());
            return new ResponseEntity<Token>(HttpStatus.BAD_REQUEST);
        }

        Optional<Token> tokenOpt = null;

        try{
            tokenOpt = merchantService.login(credentials);
        } catch (RestClientResponseException e){
            LOGGER.info("Call to test-report api failed with status : {},  description : {}", e.getStatusText(), e.getResponseBodyAsString());
        }

        if(!tokenOpt.isPresent()){
            LOGGER.info("Authentication failed, email:{}",credentials.getEmail());
            return new ResponseEntity<Token>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<Token>(tokenOpt.get(), HttpStatus.OK);
    }
}
