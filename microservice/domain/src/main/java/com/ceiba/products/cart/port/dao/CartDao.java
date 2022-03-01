package com.ceiba.products.cart.port.dao;

import com.ceiba.products.cart.model.dto.CartDto;
import com.ceiba.products.product.model.dto.SimpleProductDto;

import java.math.BigInteger;
import java.util.List;

public interface CartDao {
    boolean productAlreadySaved(BigInteger productId, BigInteger userId);
    List<CartDto> listMyCart(BigInteger userId);
}
