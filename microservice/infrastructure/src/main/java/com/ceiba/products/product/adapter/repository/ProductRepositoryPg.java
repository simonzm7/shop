package com.ceiba.products.product.adapter.repository;

import com.ceiba.infrastructure.jdbc.CustomJdbcTemplate;
import com.ceiba.products.product.model.DeleteProduct;
import com.ceiba.products.product.model.Product;
import com.ceiba.products.product.port.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
@RequiredArgsConstructor
public class ProductRepositoryPg implements ProductRepository {

    private final CustomJdbcTemplate customJdbcTemplate;

    @Override
    public BigInteger save(Product product) {
        String sql = "INSERT INTO products(product_name, description, product_category, product_image_url, product_stock, product_discount, user_id) VALUES(:productName, :description, :productCategory, :productImageUrl, :productStock, :productDiscount, :userId)";
        return this.customJdbcTemplate.create(sql, product);
    }

    @Override
    public void delete(DeleteProduct deleteProduct) {
        String sql = "DELETE FROM products WHERE id = :productId AND user_id = :userId";
        this.customJdbcTemplate.update(sql, deleteProduct);
    }

    @Override
    public void updateProduct(Product product) {
        String sql = "UPDATE products SET product_name = :productName, description = :description, product_category = :productCategory, product_image_url = :productImageUrl, product_stock = :productStock, product_discount = :productDiscount, user_id = :userId WHERE id = :id AND user_id = :userId";
        this.customJdbcTemplate.update(sql, product);
    }
}
