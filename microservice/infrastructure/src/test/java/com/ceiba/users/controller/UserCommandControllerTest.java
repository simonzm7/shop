package com.ceiba.users.controller;


import com.ceiba.ApplicationMock;
import com.ceiba.users.command.UserCommand;
import com.ceiba.users.service.testdatabuilder.UserCommandTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.math.BigInteger;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserCommandController.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class UserCommandControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;


    private static final int ID = 2;
    private static final BigInteger USER_ID = BigInteger.valueOf(ID);

    @Test
    @DisplayName("should create an user")
    void shouldCreateAnUser() throws Exception{
        UserCommand userCommand = new UserCommandTestDataBuilder().build();

        mockMvc.perform(post("/users")
        .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userCommand)))
                .andExpect(status().isOk())
                .andExpect(content().string(USER_ID.toString()));
    }
}