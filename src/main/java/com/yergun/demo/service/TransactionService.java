package com.yergun.demo.service;

import com.yergun.demo.dto.request.TransactionListRequest;
import com.yergun.demo.dto.request.TransactionReportRequest;
import com.yergun.demo.dto.response.TransactionListResponse;
import com.yergun.demo.dto.response.TransactionReportResponse;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface TransactionService {
    Optional<TransactionReportResponse> report(TransactionReportRequest transactionReportRequest, String token);
    CompletableFuture<TransactionListResponse> list(TransactionListRequest transactionListRequest, String token);
}
