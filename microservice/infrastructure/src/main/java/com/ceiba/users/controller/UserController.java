package com.ceiba.users.controller;

import com.ceiba.users.command.UserCommand;
import com.ceiba.users.command.handler.CreateUserHandler;
import com.ceiba.users.implementations.crypto.BCryptEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final BCryptEncoder encoder;
    private final CreateUserHandler createUserHandler;

    @PostMapping
    public BigInteger createUser(@RequestBody UserCommand command){
        String encodedPassword = this.encoder.encodePassword(command.getPassword());
        command.setPassword(encodedPassword);
        return this.createUserHandler.execute(command);
    }

}