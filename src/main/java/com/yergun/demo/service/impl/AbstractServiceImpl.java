package com.yergun.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class AbstractServiceImpl {

    @Autowired
    RestTemplate restTemplate;

    <T> HttpEntity<T> prepareHttpEntityWithTokenHeader(T requestObject, String token){
        MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<>();
        headerMap.add("Authorization", token);

        return new HttpEntity<>(requestObject, headerMap);
    }


}
