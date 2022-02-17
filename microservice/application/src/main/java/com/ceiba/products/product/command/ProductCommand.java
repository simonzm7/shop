package com.ceiba.products.product.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCommand {
    private BigInteger id;
    private String productName;
    private String description;
    private String productCategory;
    private String productImageUrl;
    private Integer productStock;
    private Integer productDiscount;
    private String username;
    private BigInteger userId;



    public void setUsername(String username){
        this.username = username;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }
}
