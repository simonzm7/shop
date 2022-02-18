package com.ceiba.products.product.controller;

import com.ceiba.ApplicationMock;
import com.ceiba.users.controller.UserCommandController;
import com.ceiba.users.implementations.jwt.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(UserCommandController.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)

class ProductQueryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private JwtUtil jwtUtil;


    public String jwtToken;

    @BeforeEach
    public void init(){
        final String email = "email0@email.com";
        final String requestUri = "http://";
        jwtToken = jwtUtil.createJwtToken(email, requestUri);
    }

    @Test
    @DisplayName("should fetch my products list")
    void myProductsList() throws Exception{
        this.mockMvc.perform(
                get("/product/me")
                .header("Authorization", String.format("Bearer %s", this.jwtToken)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("should fetch best discounts list")
    void bestDiscounts() throws Exception{
        this.mockMvc.perform(
                get("/product/best-discounts")
                        .header("Authorization", String.format("Bearer %s", this.jwtToken)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("should fetch discounts list")
    void discountsList() throws Exception{
        this.mockMvc.perform(
                get("/product/discounts")
                        .header("Authorization", String.format("Bearer %s", this.jwtToken)))
                .andExpect(status().isOk());
    }


    @Test
    @DisplayName("should fetch by category")
    void byCategory() throws Exception{
        this.mockMvc.perform(
                get("/product/category")
                        .header("Authorization", String.format("Bearer %s", this.jwtToken))
                        .queryParam("type", "ELECTRONICS"))
                .andExpect(status().isOk());
    }

}