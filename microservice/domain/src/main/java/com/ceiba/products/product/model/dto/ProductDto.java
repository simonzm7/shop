package com.ceiba.products.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {
    private BigInteger id;
    private String productName;
    private String description;
    private String productCategory;
    private String productImageUrl;
    private Integer productStock;
    private Integer productDiscount;
}
