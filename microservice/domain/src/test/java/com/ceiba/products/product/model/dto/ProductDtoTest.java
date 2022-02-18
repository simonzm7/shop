package com.ceiba.products.product.model.dto;

import com.ceiba.products.product.model.databuilder.ProductDtoDataBuilder;
import com.ceiba.products.product.model.databuilder.ProductMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ProductDtoTest {

    @Test
    @DisplayName("should create ProductDto object")
    void createProductDto(){
        ProductDto dto = new ProductDtoDataBuilder().build();
        assertEquals(BigInteger.ONE, dto.getId());
        assertEquals(ProductMock.PRODUCT_NAME,dto.getProductName());
        assertEquals(ProductMock.DESCRIPTION,dto.getDescription());
        assertEquals(ProductMock.PRODUCT_CATEGORY,dto.getProductCategory());
        assertEquals(ProductMock.PRODUCT_IMAGE_URL,dto.getProductImageUrl());
        assertEquals(ProductMock.PRODUCT_STOCK,dto.getProductStock());
        assertEquals(ProductMock.PRODUCT_DISCOUNT,dto.getProductDiscount());
        assertEquals(ProductMock.CREATED_AT, dto.getCreatedAt());
    }

    @Test
    @DisplayName("should create ProductDto object with new data")
    void createProductDtoWithNewData(){
        ProductDto dto = new ProductDtoDataBuilder().build();
        dto.setId(BigInteger.TEN);
        dto.setProductName("name");
        dto.setDescription("desc");
        dto.setProductCategory("FASHION");
        dto.setProductImageUrl("img");
        dto.setProductStock(0);
        dto.setProductDiscount(100);
        dto.setCreatedAt(new Date(System.currentTimeMillis() + 10 * 60 * 60).toString());
        assertNotEquals(BigInteger.ONE, dto.getId());
        assertNotEquals(ProductMock.PRODUCT_NAME,dto.getProductName());
        assertNotEquals(ProductMock.DESCRIPTION,dto.getDescription());
        assertNotEquals(ProductMock.PRODUCT_CATEGORY,dto.getProductCategory());
        assertNotEquals(ProductMock.PRODUCT_IMAGE_URL,dto.getProductImageUrl());
        assertNotEquals(ProductMock.PRODUCT_STOCK,dto.getProductStock());
        assertNotEquals(ProductMock.PRODUCT_DISCOUNT,dto.getProductDiscount());
        assertNotEquals(ProductMock.CREATED_AT, dto.getCreatedAt());
    }
}