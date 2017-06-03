package com.yergun.demo.service;

import com.yergun.demo.dto.request.TransactionListRequest;
import com.yergun.demo.dto.request.TransactionReportRequest;
import com.yergun.demo.dto.request.TransactionRequest;
import com.yergun.demo.dto.response.TransactionListResponse;
import com.yergun.demo.dto.response.TransactionReportResponse;
import com.yergun.demo.dto.response.TransactionResponse;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface TransactionService {
    Optional<TransactionReportResponse> report(TransactionReportRequest transactionReportRequest, String token);
    Optional<TransactionListResponse> list(TransactionListRequest transactionListRequest, String token);
    Optional<TransactionResponse> transaction(TransactionRequest transactionRequest, String token);
}
