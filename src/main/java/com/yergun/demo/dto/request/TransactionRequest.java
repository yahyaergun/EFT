package com.yergun.demo.dto.request;

import javax.validation.constraints.NotNull;

public class TransactionRequest {

    @NotNull
    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
