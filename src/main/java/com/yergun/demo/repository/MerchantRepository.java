package com.yergun.demo.repository;

import com.yergun.demo.model.Merchant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by yahyaergun on 31/05/2017.
 */
@RepositoryRestResource(collectionResourceRel = "merchants", path = "merchants")
public interface MerchantRepository extends PagingAndSortingRepository<Merchant, Long>{
    Merchant findByEmail(@Param("email") String email);
}
