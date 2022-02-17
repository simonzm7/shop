package com.ceiba.products.product.model;

import com.ceiba.domain.exception.LengthException;
import com.ceiba.domain.exception.RequiredException;
import com.ceiba.products.product.model.databuilder.ProductMock;
import com.ceiba.products.product.model.databuilder.ProductModelDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    @DisplayName("should throw an exception if product name is null")
    void productNameNull(){
        ProductModelDataBuilder productModelDataBuilder = new ProductModelDataBuilder();
        productModelDataBuilder.setProductName(null);
        assertThrows(RequiredException.class, ()-> productModelDataBuilder.build());

    }

    @Test
    @DisplayName("should throw an exception if product description is null")
    void descriptionNull(){
        ProductModelDataBuilder productModelDataBuilder = new ProductModelDataBuilder();
        productModelDataBuilder.setDescription(null);
        assertThrows(RequiredException.class, ()-> productModelDataBuilder.build());

    }
    @Test
    @DisplayName("should throw an exception if product category is null")
    void productCategoryNull(){
        ProductModelDataBuilder productModelDataBuilder = new ProductModelDataBuilder();
        productModelDataBuilder.setProductCategory(null);
        assertThrows(RequiredException.class, ()-> productModelDataBuilder.build());

    }

    @Test
    @DisplayName("should throw an exception if product image url is null")
    void productImageUrlNull(){
        ProductModelDataBuilder productModelDataBuilder = new ProductModelDataBuilder();
        productModelDataBuilder.setProductImageUrl(null);
        assertThrows(RequiredException.class, ()-> productModelDataBuilder.build());

    }

    @Test
    @DisplayName("should throw an exception if product discount is null")
    void productDiscountNull(){
        ProductModelDataBuilder productModelDataBuilder = new ProductModelDataBuilder();
        productModelDataBuilder.setProductDiscount(null);
        assertThrows(RequiredException.class, ()-> productModelDataBuilder.build());

    }

    @Test
    @DisplayName("should throw an exception if product stock is less than 1")
    void productStockIsLessThan(){
        ProductModelDataBuilder productModelDataBuilder = new ProductModelDataBuilder();
        productModelDataBuilder.setProductStock(0);
        assertThrows(LengthException.class, ()-> productModelDataBuilder.build());
    }

    @Test
    @DisplayName("should throw an exception if product discount is less than 0")
    void productDiscounIstLessThan(){
        ProductModelDataBuilder productModelDataBuilder = new ProductModelDataBuilder();
        productModelDataBuilder.setProductDiscount(-1);
        assertThrows(LengthException.class, ()-> productModelDataBuilder.build());
    }

    @Test
    @DisplayName("should create product object")
    void productObject(){
        Product product = new ProductModelDataBuilder().build();
        assertEquals(ProductMock.PRODUCT_NAME, product.getProductName());
        assertEquals(ProductMock.DESCRIPTION, product.getDescription());
        assertEquals(ProductMock.PRODUCT_CATEGORY, product.getProductCategory());
        assertEquals(ProductMock.PRODUCT_IMAGE_URL, product.getProductImageUrl());
        assertEquals(ProductMock.PRODUCT_STOCK, product.getProductStock());
        assertEquals(ProductMock.PRODUCT_DISCOUNT, product.getProductDiscount());
        assertEquals(ProductMock.USERNAME, product.getUsername());

    }
}