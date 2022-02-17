package com.ceiba.products.product.port.dao;

import com.ceiba.products.product.model.dto.ProductDto;

import java.util.List;

public interface ProductDao {
    List<ProductDto> listMyProductsByEmail(String email);
}
