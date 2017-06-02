package com.yergun.demo.service;

import com.yergun.demo.dto.request.TransactionReportRequest;
import com.yergun.demo.dto.response.TransactionReportBaseResponse;

import java.util.Optional;

public interface TransactionService {
    Optional<TransactionReportBaseResponse> report(TransactionReportRequest transactionReportRequest, String token);
}
