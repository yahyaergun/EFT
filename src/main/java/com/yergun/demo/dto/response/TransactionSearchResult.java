package com.yergun.demo.dto.response;

import com.yergun.demo.model.*;

import java.util.List;

public class TransactionSearchResult {

    private Fx fx;
    private CustomerInfo customerInfo;
    private List<Acquirer> acquirerTransactions;
    private Merchant merchant;
    private List<MerchantTransaction> merchantTransaction;

    public Fx getFx() {
        return fx;
    }

    public void setFx(Fx fx) {
        this.fx = fx;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public List<Acquirer> getAcquirerTransactions() {
        return acquirerTransactions;
    }

    public void setAcquirerTransactions(List<Acquirer> acquirerTransactions) {
        this.acquirerTransactions = acquirerTransactions;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public List<MerchantTransaction> getMerchantTransaction() {
        return merchantTransaction;
    }

    public void setMerchantTransaction(List<MerchantTransaction> merchantTransaction) {
        this.merchantTransaction = merchantTransaction;
    }
}
