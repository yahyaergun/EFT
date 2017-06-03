package com.yergun.demo.service.impl;

import com.yergun.demo.controller.TransactionController;
import com.yergun.demo.dto.request.TransactionListRequest;
import com.yergun.demo.dto.request.TransactionReportRequest;
import com.yergun.demo.dto.response.TransactionListResponse;
import com.yergun.demo.dto.response.TransactionReportResponse;
import com.yergun.demo.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class TransactionServiceImpl extends AbstractServiceImpl implements TransactionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @Value("${api.transaction.report.url}")
    private String transactionReportUrl;

    @Value("${api.transaction.list.url}")
    private String transactionListUrl;

    @Override
    public Optional<TransactionReportResponse> report(TransactionReportRequest transactionReportRequest, String token) {
        TransactionReportResponse response = restTemplate.postForObject(transactionReportUrl,
                prepareHttpEntityWithTokenHeader(transactionReportRequest, token), TransactionReportResponse.class);
        return Optional.ofNullable(response);
    }

    @Override
    public CompletableFuture<TransactionListResponse>list(TransactionListRequest transactionListRequest, String token) {
        return CompletableFuture.supplyAsync(() -> restTemplate.postForObject(transactionListUrl,
                prepareHttpEntityWithTokenHeader(transactionListRequest, token), TransactionListResponse.class));
    }
}
