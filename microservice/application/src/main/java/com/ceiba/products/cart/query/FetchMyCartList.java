package com.ceiba.products.cart.query;


import com.ceiba.products.cart.model.dto.CartDto;
import com.ceiba.products.cart.port.dao.CartDao;
import com.ceiba.products.product.model.dto.SimpleProductDto;
import com.ceiba.products.product.port.dao.ProductDao;
import com.ceiba.users.port.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FetchMyCartList {
    private final ProductDao productDao;
    private final CartDao cartDao;
    private final UserDao userDao;

    private CartDto  addSimpleProduct(CartDto cardItem){
        SimpleProductDto simpleProductDto = this.productDao.findSimpleProduct(cardItem.getProduct().getProductId());
        cardItem.getProduct().setProductName(simpleProductDto.getProductName());
        cardItem.getProduct().setProductImageUrl(simpleProductDto.getProductImageUrl());
        return cardItem;
    }

    public List<CartDto> execute(String email){
        BigInteger userId = this.userDao.findUserIdByEmail(email);
        List<CartDto> cartList = this.cartDao.listMyCart(userId);
        return cartList.stream().map(this::addSimpleProduct).collect(Collectors.toList());
    }
}
