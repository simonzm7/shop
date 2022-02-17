package com.ceiba.products.product.model;

import com.ceiba.common.CommonFunctions;
import com.ceiba.domain.validation.InputValidation;
import lombok.Getter;

import java.math.BigInteger;

@Getter
public class DeleteProduct {
    private BigInteger productId;
    private String userEmail;
    private BigInteger userId;

    public DeleteProduct(
            BigInteger productId,
            String userEmail
    ){
        InputValidation.notNull(productId, CommonFunctions.buildEmptyErrorMessage("product id"));
        this.productId = productId;
        this.userEmail = userEmail;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }
}
