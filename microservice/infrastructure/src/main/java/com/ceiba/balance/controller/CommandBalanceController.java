package com.ceiba.balance.controller;


import com.ceiba.balance.command.BalanceCommand;
import com.ceiba.balance.command.handler.AddBalanceHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
@RequiredArgsConstructor
public class CommandBalanceController {

    private final AddBalanceHandler addBalanceHandler;

    private String getUser(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    @PostMapping
    public ResponseEntity<?> addBalance(@RequestBody BalanceCommand command){
        command.setUserEmail(this.getUser());
        this.addBalanceHandler.execute(command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
