package com.ceiba.products.product.controller;


import com.ceiba.products.product.command.ProductCommand;
import com.ceiba.products.product.command.DeleteProductCommand;
import com.ceiba.products.product.command.handler.CreateProductHandler;
import com.ceiba.products.product.command.handler.DeleteProductHandler;
import com.ceiba.products.product.command.handler.UpdateProductHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductCommandController {

    private final CreateProductHandler createProductHandler;
    private final DeleteProductHandler deleteProductHandler;
    private final UpdateProductHandler updateProductHandler;

    private String getUser(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    @PostMapping
    public ResponseEntity<BigInteger> createProduct(@RequestBody ProductCommand command){
        command.setUsername(this.getUser());
        return new ResponseEntity<>
                (this.createProductHandler.execute(command), HttpStatus.CREATED);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody DeleteProductCommand command){
        command.setUserEmail(this.getUser());
         this.deleteProductHandler.execute(command);
    }

    @PostMapping("/{id}")
    public void updateProduct(@RequestBody ProductCommand command, @PathVariable("id") BigInteger id){
        command.setId(id);
        command.setUsername(this.getUser());
        this.updateProductHandler.execute(command);
    }
}
