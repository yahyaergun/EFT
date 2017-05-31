package com.yergun.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by yahyaergun on 01/06/2017.
 */
@Entity
public class Fx {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private MerchantWalletInfo merchant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MerchantWalletInfo getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantWalletInfo merchant) {
        this.merchant = merchant;
    }
}
