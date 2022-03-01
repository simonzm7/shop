package com.ceiba.products.cart.config;


import com.ceiba.products.cart.port.dao.CartDao;
import com.ceiba.products.cart.port.repository.CartRepository;
import com.ceiba.products.cart.service.AddProductCartService;
import com.ceiba.products.product.port.dao.ProductDao;
import com.ceiba.users.port.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanCartService {

    @Bean
    AddProductCartService addProductCartService(CartDao cartDao, CartRepository cartRepository, UserDao userDao, ProductDao productDao){
        return new AddProductCartService(cartDao, cartRepository, userDao, productDao);
    }
}
