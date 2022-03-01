package com.ceiba.products.cart.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Getter
@NoArgsConstructor
public class CartCommand {
    BigInteger productId;
    String userEmail;

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
