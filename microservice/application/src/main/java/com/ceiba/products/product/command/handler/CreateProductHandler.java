package com.ceiba.products.product.command.handler;

import com.ceiba.handler.CommandResponseHandler;
import com.ceiba.products.product.command.ProductCommand;
import com.ceiba.products.product.factory.ProductFactory;
import com.ceiba.products.product.service.CreateProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
@RequiredArgsConstructor
public class CreateProductHandler implements CommandResponseHandler<ProductCommand, BigInteger> {

    private final CreateProductService createProductService;
    private final ProductFactory productFactory;

    @Override
    public BigInteger execute(ProductCommand command) {
        return this.createProductService.execute(this.productFactory.toProduct(command));
    }
}
