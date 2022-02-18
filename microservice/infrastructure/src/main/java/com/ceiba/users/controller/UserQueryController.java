package com.ceiba.users.controller;


import com.ceiba.users.model.dto.LocalUserDto;
import com.ceiba.users.query.FetchUserProfileHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserQueryController {

    private final FetchUserProfileHandler fetchUserProfileHandler;

    private String getUser(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    @GetMapping("/me")
    public Optional<LocalUserDto> getProfile(){
        return this.fetchUserProfileHandler.execute(this.getUser());
    }
}
