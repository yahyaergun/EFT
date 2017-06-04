package com.yergun.demo.eft;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yergun.demo.model.Credentials;
import com.yergun.demo.model.Token;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AbstractControllerTest {

    @Value("${demo.account.email}")
    String testEmail;

    @Value("${demo.account.password}")
    String testPassword;

    @Value("${api.login.url}")
    String loginUrl;

    @Value("${test.valid.transaction.id}")
    String validTransactionId;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MockMvc mockMvc;

    Token validToken;
    ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        //used on request serialization to json in tests.
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        validToken = restTemplate.postForObject(loginUrl, new Credentials(testEmail, testPassword), Token.class);
    }

}
