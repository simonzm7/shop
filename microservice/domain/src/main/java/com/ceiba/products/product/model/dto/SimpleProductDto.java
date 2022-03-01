package com.ceiba.products.product.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimpleProductDto {
    private BigInteger productId;
    private String productName;
    private String productImageUrl;


}
