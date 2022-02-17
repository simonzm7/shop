package com.ceiba.products.product.factory;

import com.ceiba.products.product.command.ProductCommand;
import com.ceiba.products.product.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFactory {

    public Product toProduct(ProductCommand command){
        return new Product(
                command.getId(),
                command.getProductName(),
                command.getDescription(),
                command.getProductCategory(),
                command.getProductImageUrl(),
                command.getProductStock(),
                command.getProductDiscount(),
                command.getUsername()
        );
    }
}
