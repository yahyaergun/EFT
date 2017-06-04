package com.yergun.demo.eft;


import com.yergun.demo.model.Credentials;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LoginControllerTest extends AbstractControllerTest {

    @Test
    public void testLoginWithNoCredentials() throws Exception {
        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testLoginWithBadCredentials() throws Exception {
        mockMvc.perform(post("/login").content(objectMapper.writeValueAsString(new Credentials("bademail@bad.com", "123")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    //not testing happy path, successful login used on other tests anyway.
}
