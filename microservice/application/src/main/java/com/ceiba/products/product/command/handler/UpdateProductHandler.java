package com.ceiba.products.product.command.handler;

import com.ceiba.handler.CommandHandler;
import com.ceiba.products.product.command.ProductCommand;
import com.ceiba.products.product.factory.ProductFactory;
import com.ceiba.products.product.service.UpdateProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateProductHandler implements CommandHandler<ProductCommand> {

    private final ProductFactory productFactory;
    private final UpdateProductService updateProductService;

    @Override
    public void execute(ProductCommand command) {
        this.updateProductService.execute(this.productFactory.toProduct(command));
    }
}
