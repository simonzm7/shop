package com.ceiba.products.cart.adapter;

import com.ceiba.products.cart.model.dto.CartDto;
import com.ceiba.products.product.model.dto.SimpleProductDto;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartMapper implements RowMapper<CartDto> {
    @Override
    public CartDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        BigInteger id = BigInteger.valueOf(rs.getLong("id"));
        BigInteger productId = BigInteger.valueOf(rs.getLong("product_id"));

        SimpleProductDto simpleProductDto = new SimpleProductDto();
        simpleProductDto.setProductId(productId);
        return new CartDto(
                id,
                simpleProductDto
        );
    }
}
