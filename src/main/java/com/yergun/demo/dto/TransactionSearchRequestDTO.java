package com.yergun.demo.dto;

import com.yergun.demo.model.*;

import java.util.Date;

/**
 * Created by yahyaergun on 01/06/2017.
 */
public class TransactionSearchRequestDTO {
    private Date fromDate;
    private Date toDate;
    private Status status;
    private Operation operation;
    private Long merchantId;
    private Long acquirerId;
    private PaymentMethod paymentMethod;
    private ErrorCode errorCode;
    private FilterField filterField;
    private String filterValue;
    private Integer page;

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getAcquirerId() {
        return acquirerId;
    }

    public void setAcquirerId(Long acquirerId) {
        this.acquirerId = acquirerId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public FilterField getFilterField() {
        return filterField;
    }

    public void setFilterField(FilterField filterField) {
        this.filterField = filterField;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
