package com.ceiba.products.product.factory;

import com.ceiba.products.product.command.DeleteProductCommand;
import com.ceiba.products.product.model.DeleteProduct;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductFactory {

    public DeleteProduct toDeleteProduct(DeleteProductCommand command){
        return new DeleteProduct(
                command.getProductId(),
                command.getUserEmail()
        );
    }
}
