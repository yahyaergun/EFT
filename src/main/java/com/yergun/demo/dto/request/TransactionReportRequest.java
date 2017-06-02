package com.yergun.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class TransactionReportRequest {

    @NotNull
    @Valid
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fromDate;

    @NotNull
    @Valid
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date toDate;

    private Integer merchant;
    private Integer acquirer;

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

    public Integer getMerchant() {
        return merchant;
    }

    public void setMerchant(Integer merchant) {
        this.merchant = merchant;
    }

    public Integer getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(Integer acquirer) {
        this.acquirer = acquirer;
    }
}
