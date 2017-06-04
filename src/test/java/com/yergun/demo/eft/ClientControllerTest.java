package com.yergun.demo.eft;

import com.yergun.demo.dto.request.TransactionRequest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


public class ClientControllerTest extends AbstractControllerTest {

    @Test
    public void testUnauthorizedRequestToClient() throws Exception{
        mockMvc.perform(post("/client")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testAuthorizedRequestToClient() throws Exception {

        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setTransactionId(validTransactionId);

        MvcResult result = mockMvc.perform(post("/client").header("Authorization", validToken.getToken())
                .content(objectMapper.writeValueAsString(transactionRequest))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        assertTrue(content.contains("customerInfo"));

    }


}
