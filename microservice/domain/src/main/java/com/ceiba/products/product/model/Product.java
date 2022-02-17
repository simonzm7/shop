package com.ceiba.products.product.model;

import com.ceiba.common.CommonFunctions;
import com.ceiba.domain.validation.InputValidation;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Getter
@NoArgsConstructor
public class Product {

    private static final String STOCK_QUANTITY_ERROR = "The minimum stock value must be 1";
    private static final String DISCOUNT_PERCENTAGE_ERROR = "The minimum discount value must be 0";
    enum ProductCategory {
        ELECTRONICS
    }
    private BigInteger id;
    private String productName;
    private String description;
    private String productCategory;
    private String productImageUrl;
    private Integer productStock;
    private Integer productDiscount;
    private String username;
    private BigInteger userId;

    public Product(
            BigInteger id,
            String productName,
            String description,
            String productCategory,
            String productImageUrl,
            Integer productStock,
            Integer productDiscount,
            String username
    ){

        InputValidation.notNull(productName, CommonFunctions.buildEmptyErrorMessage("product name"));
        InputValidation.notNull(description, CommonFunctions.buildEmptyErrorMessage("description"));
        InputValidation.notNull(productCategory, CommonFunctions.buildEmptyErrorMessage("product category"));
        InputValidation.notNull(productImageUrl, CommonFunctions.buildEmptyErrorMessage("product image url"));
        InputValidation.notNull(productStock, CommonFunctions.buildEmptyErrorMessage("product stock"));
        InputValidation.notNull(productDiscount, CommonFunctions.buildEmptyErrorMessage("product discount"));
        InputValidation.isMinLength(productStock, 1, STOCK_QUANTITY_ERROR);
        InputValidation.isMinLength(productDiscount, 0, DISCOUNT_PERCENTAGE_ERROR);

        //IMAGE WIDTH AND HEIGHT!!!
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.productCategory = ProductCategory.ELECTRONICS.toString();
        this.productImageUrl = productImageUrl;
        this.productStock = productStock;
        this.productDiscount = productDiscount;
        this.username = username;
    }

    public void setUserId(BigInteger userId){
        this.userId = userId;
    }
}
