package com.ceiba.products.cart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Cart {
    private BigInteger id;
    private BigInteger productId;
    private String userEmail;
    private BigInteger userId;

    public Cart(
            BigInteger productId,
            String userEmail
    ){

        this.productId = productId;
        this.userEmail = userEmail;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }
}
