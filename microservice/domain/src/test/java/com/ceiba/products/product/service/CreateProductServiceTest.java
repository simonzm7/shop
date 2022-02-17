package com.ceiba.products.product.service;

import com.ceiba.products.product.model.Product;
import com.ceiba.products.product.model.databuilder.ProductModelDataBuilder;
import com.ceiba.products.product.port.repository.ProductRepository;
import com.ceiba.users.port.dao.UserDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;


class CreateProductServiceTest {

    @Test
    @DisplayName("should save a product")
    void saveProduct(){
        Product product = new ProductModelDataBuilder().build();

        UserDao userDao = Mockito.mock(UserDao.class);
        Mockito.when(userDao.findUserIdByEmail(product.getUsername())).thenReturn(BigInteger.TEN);


        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        Mockito.when(productRepository.save(product)).thenReturn(BigInteger.TWO);

        CreateProductService createProductService = new CreateProductService(productRepository, userDao);
        BigInteger productId = createProductService.execute(product);
        assertEquals(BigInteger.TWO, productId);
        Mockito.verify(productRepository, Mockito.times(1)).save(product);
    }

}