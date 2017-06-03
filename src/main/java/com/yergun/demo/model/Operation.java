package com.yergun.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Operation {
    DIRECT("DIRECT"),
    REFUND("REFUND"),
    THREE_D("3D"),
    THREE_D_AUTH("3DAUTH"),
    STORED("STORED");

    private final String value;

    Operation(String value) {
        this.value = value;
    }

    @JsonValue
    public String toValue() {
        return value;
    }

    @JsonCreator
    public static Operation forValue(String value) {
        if (value != null) {
            for (Operation operation : Operation.values()) {
                if (value.equalsIgnoreCase(operation.toValue())) {
                    return operation;
                }
            }
        }
        return null;
    }
}

