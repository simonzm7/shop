package com.ceiba.users.controller;

import com.ceiba.users.command.UserCommand;
import com.ceiba.users.command.handler.CreateUserHandler;
import com.ceiba.users.implementations.crypto.BCryptEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserCommandController {

    private final BCryptEncoder encoder;
    private final CreateUserHandler createUserHandler;

    @PostMapping
    public BigInteger createUser(@RequestBody UserCommand command){
        String encodedPassword = this.encoder.encodePassword(command.getPassword());
        command.setPassword(encodedPassword);
        return this.createUserHandler.execute(command);
    }

    @GetMapping
    public String getProfile(){
        return "Hello World";
    }

}
