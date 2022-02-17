package com.ceiba.products.product.model;

import com.ceiba.domain.exception.RequiredException;
import com.ceiba.products.product.model.databuilder.DeleteProductDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class DeleteProductTest {


    @Test
    @DisplayName("should throw exception if product id is null")
    void nullProductId(){
        DeleteProductDataBuilder deleteProductDataBuilder = new DeleteProductDataBuilder();
        deleteProductDataBuilder.withProductId(null);
        assertThrows(RequiredException.class, () -> deleteProductDataBuilder.build());
    }

    @Test
    @DisplayName("should create DeleteProduct object")
    void deteleProductObj(){
        final String email = "email0@email.com";
        DeleteProduct deleteProduct = new DeleteProductDataBuilder().build();
        deleteProduct.setUserId(BigInteger.TWO);
        assertEquals(BigInteger.ONE, deleteProduct.getProductId());
        assertEquals(email, deleteProduct.getUserEmail());
        assertEquals(BigInteger.TWO, deleteProduct.getUserId());

    }

}