package com.yergun.demo.controller;

import com.yergun.demo.dto.request.TransactionRequest;
import com.yergun.demo.dto.request.TransactionListRequest;
import com.yergun.demo.dto.request.TransactionReportRequest;
import com.yergun.demo.dto.response.TransactionResponse;
import com.yergun.demo.dto.response.TransactionListResponse;
import com.yergun.demo.dto.response.TransactionReportResponse;
import com.yergun.demo.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientResponseException;

import javax.validation.Valid;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@EnableAsync
@RequestMapping(value = {"/transactions", "/transaction"})
public class TransactionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<TransactionReportResponse> transactionReport(@RequestBody @Valid TransactionReportRequest transactionReportRequest,
                                                                @RequestHeader("Authorization") String token, BindingResult bindingResult) {
        LOGGER.info("Transaction Report request received with token:{}", token);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<TransactionReportResponse> responseOpt = Optional.empty();

        try {
            responseOpt = transactionService.report(transactionReportRequest, token);
        } catch (RestClientResponseException e) {
            LOGGER.error("'/transactions/report' api call failed with status : {},  description : {} ", e.getStatusText(), e.getResponseBodyAsString());
        }

        if (responseOpt.isPresent()) {
            return new ResponseEntity<>(responseOpt.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @Async
    public @ResponseBody CompletableFuture<ResponseEntity<TransactionListResponse>> transactionList (@RequestBody @Valid TransactionListRequest transactionListRequest,
                                                                                                     @RequestHeader("Authorization") String token, BindingResult bindingResult) {
        LOGGER.info("Transaction list request received with token:{}", token);

        if (bindingResult.hasErrors()) {
            return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }

        return CompletableFuture.supplyAsync(() -> transactionService.list(transactionListRequest, token))
                .thenApply((result) -> {
                    if (result.isPresent()) {
                        return new ResponseEntity<>(result.get(), HttpStatus.OK);
                    }
                    return new ResponseEntity<TransactionListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                })
                .exceptionally((error) -> {
                            LOGGER.error("Error on transaction query endpoint, details:{}", error.getLocalizedMessage());
                            throw new RuntimeException(error);
                        }
                );
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<TransactionResponse> transaction(@RequestBody TransactionRequest transactionRequest,
                                                                         @RequestHeader("Authorization") String token, BindingResult bindingResult) {
        LOGGER.info("Transaction list request received with token:{}", token);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<TransactionResponse> responseOpt = Optional.empty();

        try {
            responseOpt = transactionService.transaction(transactionRequest, token);
        } catch (RestClientResponseException e) {
            LOGGER.error("'/transaction' api call failed with status : {},  description : {} ", e.getStatusText(), e.getResponseBodyAsString());
        }

        if (responseOpt.isPresent()) {
            return new ResponseEntity<>(responseOpt.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
