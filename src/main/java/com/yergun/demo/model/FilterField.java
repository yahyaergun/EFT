package com.yergun.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by yahyaergun on 01/06/2017.
 */
public enum FilterField {

    TX_UUID("Transaction UUID"),
    CUST_EMAIL("Customer Email"),
    REF_NO("Reference No"),
    CUSTOM_DATA("Custom Data"),
    CARD_PAN("Card Pan");

    private final String value;

    FilterField(String value) {
        this.value = value;
    }

    @JsonValue
    public String toValue() {
        return value;
    }

    @JsonCreator
    public static FilterField forValue(String value) {
        if (value != null) {
            for (FilterField filterField : FilterField.values()) {
                if (value.equalsIgnoreCase(filterField.toValue())) {
                    return filterField;
                }
            }
        }
        return null;
    }



}
