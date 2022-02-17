package com.ceiba.products.product.service;

import com.ceiba.products.product.model.Product;
import com.ceiba.products.product.port.repository.ProductRepository;
import com.ceiba.users.port.dao.UserDao;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;

@RequiredArgsConstructor
public class UpdateProductService {

    private final UserDao userDao;
    private final ProductRepository productRepository;

    public void execute(Product product){
        BigInteger userId = userDao.findUserIdByEmail(product.getUsername());
        product.setUserId(userId);
        this.productRepository.updateProduct(product);
    }
}
