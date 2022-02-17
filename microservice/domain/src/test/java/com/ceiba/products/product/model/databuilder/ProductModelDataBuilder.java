package com.ceiba.products.product.model.databuilder;

import com.ceiba.products.product.model.Product;

import java.math.BigInteger;


public class ProductModelDataBuilder {
    private BigInteger id;
    private String productName;
    private String description;
    private String productCategory;
    private String productImageUrl;
    private Integer productStock;
    private Integer productDiscount;
    private String username;
    public ProductModelDataBuilder(){
        this.id = BigInteger.ONE;
        this.productName = ProductMock.PRODUCT_NAME;
        this.description = ProductMock.DESCRIPTION;
        this.productCategory = ProductMock.PRODUCT_CATEGORY;
        this.productImageUrl = ProductMock.PRODUCT_IMAGE_URL;
        this.productStock = ProductMock.PRODUCT_STOCK;
        this.productDiscount = ProductMock.PRODUCT_DISCOUNT;
        this.username = ProductMock.USERNAME;
    }

    public Product build(){
        return new Product(
                this.id,
                this.productName,
                this.description,
                this.productCategory,
                this.productImageUrl,
                this.productStock,
                this.productDiscount,
                this.username
        );
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public void setProductDiscount(Integer productDiscount) {
        this.productDiscount = productDiscount;
    }

}
