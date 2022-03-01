package com.ceiba.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthUserUtil {

    public String getUser(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }
}
