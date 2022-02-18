package com.ceiba.balance.controller;

import com.ceiba.ApplicationMock;
import com.ceiba.balance.command.BalanceCommand;
import com.ceiba.balance.databuilder.BalanceCommandDataBuilder;
import com.ceiba.users.controller.UserCommandController;
import com.ceiba.users.implementations.jwt.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserCommandController.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CommandBalanceControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtUtil jwtUtil;

    private String jwtToken;

    @BeforeEach
    public void init(){
        final String email = "email0@email.com";
        final String requestUri = "http://";
        this.jwtToken = jwtUtil.createJwtToken(email, requestUri);
    }


    @Test
    @DisplayName("should increment balance")
    void incrementBalance() throws Exception{
        BalanceCommand command = new BalanceCommandDataBuilder().build();
        this.mockMvc.perform(
                put("/balance")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(command))
                        .header("Authorization", String.format("Bearer %s", this.jwtToken))
        ).andExpect(status().isCreated());
    }
}