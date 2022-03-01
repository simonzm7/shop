package com.ceiba.products.product.adapter.dao;

import com.ceiba.infrastructure.jdbc.CustomJdbcTemplate;
import com.ceiba.infrastructure.jdbc.sqlstatement.SqlStatement;
import com.ceiba.products.product.adapter.mapper.ProductMapper;
import com.ceiba.products.product.factory.SimpleProductFactory;
import com.ceiba.products.product.model.dto.ProductDto;
import com.ceiba.products.product.model.dto.SimpleProductDto;
import com.ceiba.products.product.model.enums.ProductCategory;
import com.ceiba.products.product.port.dao.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component @RequiredArgsConstructor
public class ProductDaoPg implements ProductDao {

    @SqlStatement(namespace = "product", value ="productExists")
    private static String sqlProductExists;

    @SqlStatement(namespace = "product", value ="myProductsByEmail")
    private static String sqlMyProductsByEmail;

    @SqlStatement(namespace = "product", value ="bestDiscountsProducts")
    private static String sqlBestDiscountsProducts;

    @SqlStatement(namespace = "product", value ="discountProducts")
    private static String sqlDiscountProducts;

    @SqlStatement(namespace = "product", value ="listByCategory")
    private static String sqlListByCategory;

    @SqlStatement(namespace = "product", value ="listByCategoryAndDeals")
    private static String sqlListByCategoryAndDeals;

    @SqlStatement(namespace = "product", value ="simpleProduct")
    private static String sqlSimpleProduct;

    private final CustomJdbcTemplate customJdbcTemplate;

    @Override
    public boolean productExists(BigInteger productId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("productId", productId);
        return this.customJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlProductExists, mapSqlParameterSource, Boolean.class);
    }

    @Override
    public List<ProductDto> listMyProductsByEmail(BigInteger userId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("userId", userId);
        return this.customJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlMyProductsByEmail, mapSqlParameterSource, new ProductMapper());
    }

    @Override
    public List<ProductDto> listBestDiscountProducts() {
        return this.customJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBestDiscountsProducts, new ProductMapper());
    }

    @Override
    public List<ProductDto> listDiscountProducts() {
        return this.customJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlDiscountProducts, new ProductMapper());
    }

    @Override
    public List<ProductDto> listByCategory(ProductCategory category) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("productCategory", category.toString());
        return this.customJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListByCategory, mapSqlParameterSource, new ProductMapper());
    }

    @Override
    public List<ProductDto> listByCategoryAndDeals(ProductCategory category) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("productCategory", category.toString());
        return this.customJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListByCategoryAndDeals, mapSqlParameterSource, new ProductMapper());
    }

    @Override
    public SimpleProductDto findSimpleProduct(BigInteger productId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("productId", productId);
        return this.customJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlSimpleProduct, mapSqlParameterSource, new SimpleProductFactory());
    }
}
