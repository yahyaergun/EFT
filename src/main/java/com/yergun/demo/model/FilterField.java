package com.yergun.demo.model;

/**
 * Created by yahyaergun on 01/06/2017.
 */
public enum FilterField {

    TX_UUID("Transaction UUID"),
    CUST_EMAIL("Customer Email"),
    REF_NO("Reference No"),
    CUSTOM_DATA("Custom Data"),
    CARD_PAN("Card Pan");

    private final String filterFieldDesc;

    FilterField(String filterFieldDesc) {
        this.filterFieldDesc = filterFieldDesc;
    }

    public String getFilterFieldDesc() {
        return filterFieldDesc;
    }
}
