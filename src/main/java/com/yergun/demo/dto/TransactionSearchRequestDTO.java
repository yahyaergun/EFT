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
}
