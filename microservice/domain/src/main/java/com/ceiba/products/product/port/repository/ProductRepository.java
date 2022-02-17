package com.ceiba.products.product.port.repository;

import com.ceiba.products.product.model.DeleteProduct;
import com.ceiba.products.product.model.Product;

import java.math.BigInteger;

public interface ProductRepository {
    BigInteger save(Product product);
    void delete(DeleteProduct deleteProduct);
    void updateProduct(Product product);
}
