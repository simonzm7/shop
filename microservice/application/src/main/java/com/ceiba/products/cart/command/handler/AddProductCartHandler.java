package com.ceiba.products.cart.command.handler;

import com.ceiba.handler.CommandHandler;
import com.ceiba.products.cart.command.CartCommand;
import com.ceiba.products.cart.command.factory.CartFactory;
import com.ceiba.products.cart.service.AddProductCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddProductCartHandler implements CommandHandler<CartCommand> {

    private final CartFactory cartFactory;
    private final AddProductCartService addProductCartService;

    @Override
    public void execute(CartCommand command) {
        this.addProductCartService.execute(this.cartFactory.toCart(command));
    }
}
