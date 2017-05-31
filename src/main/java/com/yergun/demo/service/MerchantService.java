package com.yergun.demo.service;

import com.yergun.demo.model.Merchant;
import com.yergun.demo.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yahyaergun on 31/05/2017.
 */
@Service
public class MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    public boolean authenticate(String email, String password){
        Merchant merchant = merchantRepository.findByEmail(email);
        return null != merchant && password.equals(merchant.getPassword());
    }
}
