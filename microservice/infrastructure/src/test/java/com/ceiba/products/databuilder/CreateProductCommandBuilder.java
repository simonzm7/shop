package com.ceiba.products.databuilder;

import com.ceiba.products.product.command.ProductCommand;

import java.math.BigInteger;

public class CreateProductCommandBuilder {

    private String productName;
    private String description;
    private String productCategory;
    private String productImageUrl;
    private Integer productStock;
    private Integer productDiscount;
    private String username;

    public CreateProductCommandBuilder(){
        this.productName = "MacBook Pro";
        this.description = "MackBook Pro with chip M1 And 15 Inches.";
        this.productCategory = "ELECTRONICS";
        this.productImageUrl = "https://localhost/img.png";
        this.productStock = 10;
        this.productDiscount = 5;
        this.username = "username";
    }

    public ProductCommand build(){
        return new ProductCommand(
                BigInteger.ONE,
                this.productName,
                this.description,
                this.productCategory,
                this.productImageUrl,
                this.productStock,
                this.productDiscount,
                this.username,
                BigInteger.TWO
        );
    }
}
