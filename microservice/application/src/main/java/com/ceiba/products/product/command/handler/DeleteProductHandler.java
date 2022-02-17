package com.ceiba.products.product.command.handler;

import com.ceiba.handler.CommandHandler;
import com.ceiba.products.product.command.DeleteProductCommand;
import com.ceiba.products.product.factory.DeleteProductFactory;
import com.ceiba.products.product.service.DeleteProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteProductHandler implements CommandHandler<DeleteProductCommand> {

    private final DeleteProductFactory deleteProductFactory;
    private final DeleteProductService deleteProductService;
    @Override
    public void execute(DeleteProductCommand command) {
        this.deleteProductService.execute(this.deleteProductFactory.toDeleteProduct(command));
    }
}
