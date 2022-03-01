package com.ceiba.products.cart.model.dto;

import com.ceiba.products.product.model.dto.SimpleProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

    private BigInteger id;
    private SimpleProductDto product;

    public void setProduct(SimpleProductDto product) {
        this.product = product;
    }
}
