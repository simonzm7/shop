package com.ceiba.products.product.adapter.mapper;

import com.ceiba.products.product.model.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

@Slf4j
public class ProductMapper implements RowMapper<ProductDto>
{
    @Override
    public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        BigInteger id = BigInteger.valueOf(rs.getLong("id"));
        String productName = rs.getString("product_name");
        String description =  rs.getString("description");
        String productCategory =  rs.getString("product_category");
        String productImageUrl =  rs.getString("product_image_url");
        Integer productStock = rs.getInt("product_stock");
        Integer productDiscount = rs.getInt("product_discount");
        String createdAt = rs.getString("created_at");
        return new ProductDto(
                id,
                productName,
                description,
                productCategory,
                productImageUrl,
                productStock,
                productDiscount,
                createdAt
        );
    }
}
