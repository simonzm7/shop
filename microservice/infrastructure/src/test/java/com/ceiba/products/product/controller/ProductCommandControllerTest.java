package com.ceiba.products.product.controller;

import com.ceiba.ApplicationMock;
import com.ceiba.products.product.command.ProductCommand;
import com.ceiba.products.product.command.DeleteProductCommand;
import com.ceiba.products.databuilder.CreateProductCommandBuilder;
import com.ceiba.products.databuilder.DeleteProductCommandBuilder;
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

import java.math.BigInteger;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(UserCommandController.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ProductCommandControllerTest {

    private static final String PRODUCT_ID = "2";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

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
    @DisplayName("should create a product")
    void createProduct() throws  Exception{
        ProductCommand command = new CreateProductCommandBuilder().build();


        this.mockMvc.perform(post("/product")
        .contentType(MediaType.APPLICATION_JSON)
        .content(this.objectMapper.writeValueAsString(command))
        .header("Authorization", String.format("Bearer %s", this.jwtToken)))
                .andExpect(status().isCreated())
                .andExpect(content().string(PRODUCT_ID));
    }

    @Test
    @DisplayName("should update a product")
    void updateProduct() throws  Exception{
        DeleteProductCommand command = new DeleteProductCommandBuilder().build();
        this.mockMvc.perform(delete("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(command))
                .param("id", BigInteger.ONE.toString())
                .header("Authorization", String.format("Bearer %s", jwtToken)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("should delete a product")
    void deleteProduct() throws  Exception{
        DeleteProductCommand command = new DeleteProductCommandBuilder().build();
        this.mockMvc.perform(delete("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(command))
                .header("Authorization", String.format("Bearer %s", jwtToken)))
                .andExpect(status().isOk());
    }

}