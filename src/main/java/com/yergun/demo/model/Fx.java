package com.yergun.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fx {

    private MerchantWalletInfo merchant;

    public MerchantWalletInfo getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantWalletInfo merchant) {
        this.merchant = merchant;
    }
}
