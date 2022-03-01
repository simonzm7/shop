package com.ceiba.products.cart.port.repository;

import com.ceiba.products.cart.model.Cart;

public interface CartRepository {

    void save(Cart cart);
}
