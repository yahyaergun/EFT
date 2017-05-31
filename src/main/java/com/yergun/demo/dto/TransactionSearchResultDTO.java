package com.yergun.demo.dto;

import com.yergun.demo.model.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by yahyaergun on 01/06/2017.
 */
public class TransactionSearchResultDTO {

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
