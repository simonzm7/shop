package com.ceiba.products.cart.adapter.repository;

import com.ceiba.infrastructure.jdbc.CustomJdbcTemplate;
import com.ceiba.infrastructure.jdbc.sqlstatement.SqlStatement;
import com.ceiba.products.cart.model.Cart;
import com.ceiba.products.cart.port.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartRepositoryPg implements CartRepository {

    @SqlStatement(namespace = "cart", value ="saveProductCart")
    private static String sqlSave;

    private final CustomJdbcTemplate customJdbcTemplate;


    @Override
    public void save(Cart cart) {
        this.customJdbcTemplate.create(sqlSave, cart);
    }
}
