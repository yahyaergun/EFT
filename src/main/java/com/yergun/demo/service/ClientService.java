package com.yergun.demo.service;

import com.yergun.demo.dto.request.TransactionRequest;
import com.yergun.demo.dto.response.ClientResponse;

import java.util.Optional;

public interface ClientService {
    Optional<ClientResponse> customer(TransactionRequest transactionRequest, String token);
}
