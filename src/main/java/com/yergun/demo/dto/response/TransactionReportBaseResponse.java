package com.yergun.demo.dto.response;

import java.util.List;

public class TransactionReportBaseResponse {
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
