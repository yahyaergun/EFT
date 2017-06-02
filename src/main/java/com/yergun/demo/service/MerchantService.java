package com.yergun.demo.service;

import com.yergun.demo.model.Credentials;
import com.yergun.demo.model.Merchant;
import com.yergun.demo.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface MerchantService {
    Optional<Token> login(Credentials credentials);
}
