package com.ceiba.products.product.model.databuilder;

import com.ceiba.products.product.model.dto.ProductDto;

import java.math.BigInteger;

public class ProductDtoDataBuilder {

    private BigInteger id;
    private String productName;
    private String description;
    private String productCategory;
    private String productImageUrl;
    private Integer productStock;
    private Integer productDiscount;
    private String createdAt;

    public ProductDtoDataBuilder(){
        this.id = BigInteger.ONE;
        this.productName = ProductMock.PRODUCT_NAME;
        this.description = ProductMock.DESCRIPTION;
        this.productCategory = ProductMock.PRODUCT_CATEGORY;
        this.productImageUrl = ProductMock.PRODUCT_IMAGE_URL;
        this.productStock = ProductMock.PRODUCT_STOCK;
        this.productDiscount = ProductMock.PRODUCT_DISCOUNT;
        this.createdAt = ProductMock.CREATED_AT;
    }

    public ProductDto build(){
        return new ProductDto(
                this.id,
                this.productName,
                this.description,
                this.productCategory,
                this.productImageUrl,
                this.productStock,
                this.productDiscount,
                this.createdAt
        );
    }
}
