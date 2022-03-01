package com.ceiba.products.cart.command.factory;

import com.ceiba.products.cart.command.CartCommand;
import com.ceiba.products.cart.model.Cart;
import org.springframework.stereotype.Component;

@Component
public class CartFactory {

    public Cart toCart(CartCommand command){
        return new Cart(
                command.getProductId(),
                command.getUserEmail()
        );
    }
}
