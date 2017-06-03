package com.yergun.demo.service.impl;

import com.yergun.demo.dto.request.TransactionRequest;
import com.yergun.demo.dto.response.ClientResponse;
import com.yergun.demo.model.CustomerInfo;
import com.yergun.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl extends AbstractServiceImpl implements ClientService {

    @Value("${api.client.url}")
    private String clientUrl;

    @Override
    public Optional<ClientResponse> customer(TransactionRequest transactionRequest, String token) {
        ClientResponse clientResponse = restTemplate.postForObject(clientUrl,
                prepareHttpEntityWithTokenHeader(transactionRequest, token), ClientResponse.class);
        return Optional.ofNullable(clientResponse);
    }
}
