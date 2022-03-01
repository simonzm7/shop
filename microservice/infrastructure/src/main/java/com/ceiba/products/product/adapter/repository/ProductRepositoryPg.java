package com.ceiba.products.product.adapter.repository;

import com.ceiba.infrastructure.jdbc.CustomJdbcTemplate;
import com.ceiba.infrastructure.jdbc.sqlstatement.SqlStatement;
import com.ceiba.products.product.model.DeleteProduct;
import com.ceiba.products.product.model.Product;
import com.ceiba.products.product.port.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
@RequiredArgsConstructor
public class ProductRepositoryPg implements ProductRepository {

    @SqlStatement(namespace = "product", value ="saveProduct")
    private static String sqlSave;

    @SqlStatement(namespace = "product", value ="deleteProduct")
    private static String sqlDeleteProduct;

    @SqlStatement(namespace = "product", value ="updateProduct")
    private static String sqlUpdateProduct;

    private final CustomJdbcTemplate customJdbcTemplate;

    @Override
    public BigInteger save(Product product) {
        return this.customJdbcTemplate.create(sqlSave, product);
    }

    @Override
    public void delete(DeleteProduct deleteProduct) {
        this.customJdbcTemplate.update(sqlDeleteProduct, deleteProduct);
    }

    @Override
    public void updateProduct(Product product) {
        this.customJdbcTemplate.update(sqlUpdateProduct, product);
    }
}
