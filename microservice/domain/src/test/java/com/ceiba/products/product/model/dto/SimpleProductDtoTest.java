package com.ceiba.products.product.model.dto;

import com.ceiba.products.product.model.databuilder.ProductMock;
import com.ceiba.products.product.model.databuilder.SimpleProductDtoDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class SimpleProductDtoTest {


    @Test
    @DisplayName("should create SimpleProductDto")
    void simpleProduct(){
        SimpleProductDto simpleProductDto = new SimpleProductDtoDataBuilder().build();
        assertNotNull(simpleProductDto);
        assertEquals(BigInteger.ONE, simpleProductDto.getProductId());
        assertEquals(ProductMock.PRODUCT_NAME, simpleProductDto.getProductName());
        assertEquals(ProductMock.PRODUCT_IMAGE_URL, simpleProductDto.getProductImageUrl());
    }

}