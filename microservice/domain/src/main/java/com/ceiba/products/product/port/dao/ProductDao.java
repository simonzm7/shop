package com.ceiba.products.product.port.dao;

import com.ceiba.products.product.model.dto.ProductDto;
import com.ceiba.products.product.model.enums.ProductCategory;

import java.math.BigInteger;
import java.util.List;

public interface ProductDao {
    List<ProductDto> listMyProductsByEmail(BigInteger userId);
    List<ProductDto> listBestDiscountProducts();
    List<ProductDto> listDiscountProducts();
    List<ProductDto> listByCategory(ProductCategory category);
    List<ProductDto> listByCategoryAndDeals(ProductCategory category);

}
