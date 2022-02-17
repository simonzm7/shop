package com.ceiba.products.product.config;

import com.ceiba.products.product.port.repository.ProductRepository;
import com.ceiba.products.product.service.CreateProductService;
import com.ceiba.products.product.service.DeleteProductService;
import com.ceiba.products.product.service.UpdateProductService;
import com.ceiba.users.port.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductBeanService {

    @Bean
    CreateProductService createProductService(ProductRepository productRepository, UserDao userDao){
        return new CreateProductService(productRepository, userDao);
    }

    @Bean
    DeleteProductService deleteProductService(UserDao userDao, ProductRepository productRepository){
        return new DeleteProductService(userDao, productRepository);
    }

    @Bean
    UpdateProductService updateProductService(UserDao userDao, ProductRepository productRepository){
        return new UpdateProductService(userDao, productRepository);
    }
}
