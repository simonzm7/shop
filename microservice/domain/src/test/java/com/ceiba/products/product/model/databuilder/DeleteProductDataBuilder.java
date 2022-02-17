package com.ceiba.products.product.model.databuilder;

import com.ceiba.products.product.model.DeleteProduct;

import java.math.BigInteger;

public class DeleteProductDataBuilder {

    private BigInteger productId;
    private String userEmail;
    private BigInteger userId;

    public DeleteProductDataBuilder(){
        this.productId = BigInteger.ONE;
        this.userEmail = "email0@email.com";
    }

    public DeleteProduct build(){
        return new DeleteProduct(
                this.productId,
                this.userEmail
        );
    }

    public void withProductId(BigInteger newProductId){
        this.productId = newProductId;
    }

}
