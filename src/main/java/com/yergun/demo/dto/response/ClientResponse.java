package com.yergun.demo.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yergun.demo.model.CustomerInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientResponse {
    private CustomerInfo customerInfo;

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }
}
