package com.ceiba.products.product.service;

import com.ceiba.products.product.model.DeleteProduct;
import com.ceiba.products.product.port.repository.ProductRepository;
import com.ceiba.users.port.dao.UserDao;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;

@RequiredArgsConstructor
public class DeleteProductService {

    private final UserDao userDao;
    private final ProductRepository productRepository;


    public void execute(DeleteProduct deleteProduct){
        BigInteger userId = this.userDao.findUserIdByEmail(deleteProduct.getUserEmail());
        deleteProduct.setUserId(userId);
        this.productRepository.delete(deleteProduct);
    }
}
