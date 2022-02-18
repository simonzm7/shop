package com.ceiba.products.product.adapter.query;

import com.ceiba.infrastructure.jdbc.CustomJdbcTemplate;
import com.ceiba.products.product.adapter.mapper.ProductMapper;
import com.ceiba.products.product.model.dto.ProductDto;
import com.ceiba.products.product.model.enums.ProductCategory;
import com.ceiba.products.product.port.dao.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component @RequiredArgsConstructor
public class ProductDaoPg implements ProductDao {

    private final CustomJdbcTemplate customJdbcTemplate;

    @Override
    public List<ProductDto> listMyProductsByEmail(BigInteger userId) {
        String sql = "SELECT id, product_name, description, product_category, product_image_url, product_stock, product_discount, created_at FROM products WHERE user_id = :userId";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("userId", userId);
        return this.customJdbcTemplate.getNamedParameterJdbcTemplate().query(sql, mapSqlParameterSource, new ProductMapper());
    }

    @Override
    public List<ProductDto> listBestDiscountProducts() {
        String sql = "SELECT id, product_name, description, product_category, product_image_url, product_stock, product_discount, created_at FROM products WHERE product_stock > 0 AND product_discount > 15 LIMIT 15";
        return this.customJdbcTemplate.getNamedParameterJdbcTemplate().query(sql, new ProductMapper());
    }

    @Override
    public List<ProductDto> listDiscountProducts() {
        String sql = "SELECT id, product_name, description, product_category, product_image_url, product_stock, product_discount, created_at FROM products WHERE product_stock > 0 AND product_discount > 0";
        return this.customJdbcTemplate.getNamedParameterJdbcTemplate().query(sql, new ProductMapper());
    }

    @Override
    public List<ProductDto> listByCategory(ProductCategory category) {
        String sql = "SELECT id, product_name, description, product_category, product_image_url, product_stock, product_discount, created_at FROM products WHERE product_stock > 0 AND product_category = :productCategory";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("productCategory", category.toString());
        return this.customJdbcTemplate.getNamedParameterJdbcTemplate().query(sql, mapSqlParameterSource, new ProductMapper());
    }

    @Override
    public List<ProductDto> listByCategoryAndDeals(ProductCategory category) {
        String sql = "SELECT id, product_name, description, product_category, product_image_url, product_stock, product_discount, created_at FROM products WHERE product_stock > 0 AND product_discount > 0 AND product_category = :productCategory";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("productCategory", category.toString());
        return this.customJdbcTemplate.getNamedParameterJdbcTemplate().query(sql, mapSqlParameterSource, new ProductMapper());
    }
}
