package com.yergun.demo.eft;

import com.yergun.demo.dto.request.TransactionListRequest;
import com.yergun.demo.dto.request.TransactionReportRequest;
import com.yergun.demo.dto.request.TransactionRequest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TransactionControllerTest extends AbstractControllerTest{

    @Test
    public void testUnauthorizedRequestToList() throws Exception {
        mockMvc.perform(post("/transactions/list")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testUnauthorizedRequestToReport() throws Exception {
        mockMvc.perform(post("/transactions/report")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testUnauthorizedRequestToTransaction() throws Exception {
        mockMvc.perform(post("/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testAuthorizedRequestToList() throws Exception {
        TransactionListRequest request = new TransactionListRequest();

        MvcResult result = mockMvc.perform(post("/transactions/list").header("Authorization", validToken.getToken())
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        Assert.assertTrue(content.contains("data"));
    }

    @Test
    public void testAuthorizedRequestToReport() throws Exception {
        TransactionReportRequest request = new TransactionReportRequest();
        request.setFromDate(new GregorianCalendar(2015, Calendar.JULY, 1).getTime());
        request.setToDate(new GregorianCalendar(2015, Calendar.OCTOBER, 1).getTime());

        MvcResult result = mockMvc.perform(post("/transactions/report").header("Authorization", validToken.getToken())
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        Assert.assertTrue(content.contains("response"));
    }

    @Test
    public void testAuthorizedRequestToTransaction() throws Exception {
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setTransactionId(validTransactionId);

        MvcResult result = mockMvc.perform(post("/transactions").header("Authorization", validToken.getToken())
                .content(objectMapper.writeValueAsString(transactionRequest))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        assertTrue(content.contains("transactionId"));
    }

}
