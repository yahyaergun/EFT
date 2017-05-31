package com.yergun.demo.repository;

import com.yergun.demo.dto.TransactionSearchResultDTO;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by yahyaergun on 01/06/2017.
 */
public interface TransactionRepository extends PagingAndSortingRepository<TransactionSearchResultDTO, Long> {
}
