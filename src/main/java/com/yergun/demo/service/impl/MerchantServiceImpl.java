package com.yergun.demo.service.impl;

import com.yergun.demo.model.Credentials;
import com.yergun.demo.model.Token;
import com.yergun.demo.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class MerchantServiceImpl extends AbstractServiceImpl implements MerchantService {

    @Value("${api.login.url}")
    private String loginUrl;

    @Override
    public Optional<Token> login(Credentials credentials) throws RestClientResponseException {
        Token token = restTemplate.postForObject(loginUrl, credentials, Token.class);
        return Optional.ofNullable(token);
    }
}
