package com.ceiba.products.product.service;

import com.ceiba.products.product.model.Product;
import com.ceiba.products.product.port.repository.ProductRepository;
import com.ceiba.users.port.dao.UserDao;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;

@RequiredArgsConstructor
public class CreateProductService {

    private final ProductRepository productRepository;
    private final UserDao userDao;

    public BigInteger execute(Product product){
        BigInteger userId = this.userDao.findUserIdByEmail(product.getUsername());
        product.setUserId(userId);
        return this.productRepository.save(product);
    }


}
