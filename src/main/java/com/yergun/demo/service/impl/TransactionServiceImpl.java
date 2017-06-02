package com.yergun.demo.service.impl;

import com.yergun.demo.dto.request.TransactionReportRequest;
import com.yergun.demo.dto.response.TransactionReportBaseResponse;
import com.yergun.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class TransactionServiceImpl extends AbstractServiceImpl implements TransactionService {

    @Value("${api.transaction.report.url}")
    private String transactionReportUrl;

    @Override
    public Optional<TransactionReportBaseResponse> report(TransactionReportRequest transactionReportRequest, String token) {
        TransactionReportBaseResponse response = restTemplate.postForObject(transactionReportUrl,
                prepareHttpEntityWithTokenHeader(transactionReportRequest, token), TransactionReportBaseResponse.class);
        return Optional.ofNullable(response);
    }
}
