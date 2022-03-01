package com.ceiba.products.product.factory;

import com.ceiba.products.product.model.dto.SimpleProductDto;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SimpleProductFactory implements RowMapper<SimpleProductDto> {
    @Override
    public SimpleProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        BigInteger id = BigInteger.valueOf(rs.getLong("id"));
        String productName = rs.getString("product_name");
        String productImageUrl = rs.getString("product_image_url");

        return new SimpleProductDto(
                id,
                productName,
                productImageUrl
        );
    }
}
