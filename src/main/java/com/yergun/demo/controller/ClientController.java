package com.yergun.demo.controller;

import com.yergun.demo.dto.request.TransactionRequest;
import com.yergun.demo.dto.response.ClientResponse;
import com.yergun.demo.dto.response.TransactionReportResponse;
import com.yergun.demo.model.CustomerInfo;
import com.yergun.demo.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientResponseException;

import java.util.Optional;

@RestController
public class ClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<ClientResponse> customer(@RequestBody TransactionRequest transactionRequest,
                                                                 @RequestHeader("Authorization") String token, BindingResult bindingResult) {
        LOGGER.info("Customer request recevied with token: {}", token);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<ClientResponse> responseOpt = Optional.empty();

        try {
            responseOpt = clientService.customer(transactionRequest, token);
        } catch (RestClientResponseException e) {
            LOGGER.error("'/client' api call failed with status : {},  description : {} ", e.getStatusText(), e.getResponseBodyAsString());
        }

        if (responseOpt.isPresent()) {
            return new ResponseEntity<>(responseOpt.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
