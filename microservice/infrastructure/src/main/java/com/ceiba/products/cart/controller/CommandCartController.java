package com.ceiba.products.cart.controller;


import com.ceiba.products.cart.command.CartCommand;
import com.ceiba.products.cart.command.handler.AddProductCartHandler;
import com.ceiba.utils.AuthUserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CommandCartController {

    private final AuthUserUtil authUserUtil;
    private final AddProductCartHandler addProductCartHandler;
    private String getUser(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody CartCommand command){
        command.setUserEmail(this.authUserUtil.getUser());
        this.addProductCartHandler.execute(command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
