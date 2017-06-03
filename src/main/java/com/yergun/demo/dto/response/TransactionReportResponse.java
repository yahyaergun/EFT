package com.yergun.demo.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionReportResponse {
    private String status;
    private List<TransactionReportResponseData> response;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TransactionReportResponseData> getResponse() {
        return response;
    }

    public void setResponse(List<TransactionReportResponseData> response) {
        this.response = response;
    }
}
