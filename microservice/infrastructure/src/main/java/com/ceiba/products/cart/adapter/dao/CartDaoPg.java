package com.ceiba.products.cart.adapter.dao;

import com.ceiba.infrastructure.jdbc.CustomJdbcTemplate;
import com.ceiba.infrastructure.jdbc.sqlstatement.SqlStatement;
import com.ceiba.products.cart.adapter.CartMapper;
import com.ceiba.products.cart.model.dto.CartDto;
import com.ceiba.products.cart.port.dao.CartDao;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CartDaoPg implements CartDao {

    @SqlStatement(namespace = "cart", value ="productAlreadySaved")
    private static String sqlAlreadySaved;

    @SqlStatement(namespace = "cart", value ="listMyCart")
    private static String sqlListMyCart;

    private final CustomJdbcTemplate customJdbcTemplate;

    @Override
    public boolean productAlreadySaved(BigInteger productId, BigInteger userId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("productId", productId);
        mapSqlParameterSource.addValue("userId", userId);
        return this.customJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlAlreadySaved, mapSqlParameterSource, Boolean.class);
    }

    @Override
    public List<CartDto> listMyCart(BigInteger userId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("userId", userId);
        return this.customJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListMyCart, mapSqlParameterSource, new CartMapper());
    }
}
