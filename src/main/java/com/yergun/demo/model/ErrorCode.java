package com.yergun.demo.model;

/**
 * Created by yahyaergun on 01/06/2017.
 */
public enum ErrorCode {
    DO_NOT_HONOR("Do not honor"),
    INV_TRX("Invalid Transaction"),
    INV_CARD("Invalid Card"),
    INSUFF_FUNDS("Not sufficient funds"),
    INCORR_PIN("Incorrect PIN"),
    INV_COUN_ASS("Invalid country association"),
    CURR_NOT_ALLOWED("Currency not allowed"),
    THREE_D_SEC_TRANS_ERR("3-D Secure Transport Error"),
    TRX_NOT_PERMITTED_CARDHOLDER("Transaction not permitted to cardholder");


    private final String errorDescription;

    ErrorCode(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

}
