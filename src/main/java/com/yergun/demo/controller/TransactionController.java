package com.yergun.demo.controller;

import com.yergun.demo.dto.request.TransactionListRequest;
import com.yergun.demo.dto.request.TransactionReportRequest;
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
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;

@RestController
@EnableAsync
@RequestMapping(value = {"/transactions", "/transaction"})
public class TransactionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<TransactionReportResponse> transactionReport(@RequestBody @Valid TransactionReportRequest transactionReportRequest,
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

        if (!responseOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseOpt.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @Async
    public @ResponseBody CompletableFuture transactionList (@RequestBody @Valid TransactionListRequest transactionListRequest,
                                                                               @RequestHeader("Authorization") String token, BindingResult bindingResult) {
        LOGGER.info("Transaction list request received with token:{}", token);
        return CompletableFuture.supplyAsync(() -> transactionService.list(transactionListRequest, token));

    }
}
