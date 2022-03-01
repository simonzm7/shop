package com.ceiba.products.cart.service;


import com.ceiba.domain.exception.DuplicatedException;
import com.ceiba.domain.exception.NotFoundException;
import com.ceiba.products.cart.model.Cart;
import com.ceiba.products.cart.port.dao.CartDao;
import com.ceiba.products.cart.port.repository.CartRepository;
import com.ceiba.products.product.port.dao.ProductDao;
import com.ceiba.users.port.dao.UserDao;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;

@RequiredArgsConstructor
public class AddProductCartService {

    private static final String PRODUCT_ERR_MESSAGE = "You cannot add the same product twice";
    private static final String PRODUCT_NOT_FOUND_ERR_MESSAGE = "The product provided does not exist";

    private final CartDao cartDao;
    private final CartRepository cartRepository;
    private final UserDao userDao;
    private final ProductDao productDao;

    private void verifyIfProductIsAlreadySaved(BigInteger productId, BigInteger userId){
        boolean exists = this.cartDao.productAlreadySaved(productId, userId);
        if (exists){
            throw new DuplicatedException(PRODUCT_ERR_MESSAGE);
        }
    }

    private void verifyIfProductDoNotExist(BigInteger productId){
        boolean exists = this.productDao.productExists(productId);
        if(!exists){
            throw new NotFoundException(PRODUCT_NOT_FOUND_ERR_MESSAGE);
        }
    }

    public void execute(Cart cart){
        this.verifyIfProductDoNotExist(cart.getProductId());

        BigInteger userId = this.userDao.findUserIdByEmail(cart.getUserEmail());
        cart.setUserId(userId);

        this.verifyIfProductIsAlreadySaved(cart.getProductId(), userId);

        this.cartRepository.save(cart);
    }
}
