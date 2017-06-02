package com.yergun.demo.service.impl;

import com.yergun.demo.model.Credentials;
import com.yergun.demo.model.Token;
import com.yergun.demo.service.MerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.login.url}")
    private String loginUrl;

    @Override
    public Optional<Token> login(Credentials credentials) throws RestClientResponseException {
        Token token = restTemplate.postForObject(loginUrl, credentials, Token.class);
        return Optional.ofNullable(token);
    }
}
