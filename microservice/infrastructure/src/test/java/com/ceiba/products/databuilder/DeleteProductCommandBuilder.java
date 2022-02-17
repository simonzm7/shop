package com.ceiba.products.databuilder;

import com.ceiba.products.product.command.DeleteProductCommand;

import java.math.BigInteger;

public class DeleteProductCommandBuilder {


    private BigInteger productId;
    private String userEmail;

    public DeleteProductCommandBuilder(){
        this.productId = BigInteger.ONE;
        this.userEmail = "email0@email.com";
    }

    public DeleteProductCommand build(){
        return new DeleteProductCommand(
                this.productId,
                this.userEmail
        );
    }
}
