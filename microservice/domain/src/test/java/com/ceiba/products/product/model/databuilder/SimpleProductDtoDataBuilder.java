package com.ceiba.products.product.model.databuilder;

import com.ceiba.products.product.model.dto.SimpleProductDto;

import java.math.BigInteger;

public class SimpleProductDtoDataBuilder {

    private BigInteger productId;
    private String productName;
    private String productImageUrl;

    public SimpleProductDtoDataBuilder(){
        this.productId = BigInteger.ONE;
        this.productName = ProductMock.PRODUCT_NAME;
        this.productImageUrl = ProductMock.PRODUCT_IMAGE_URL;
    }

    public SimpleProductDto build(){
        return new SimpleProductDto(
                this.productId,
                this.productName,
                this.productImageUrl
        );
    }
}
