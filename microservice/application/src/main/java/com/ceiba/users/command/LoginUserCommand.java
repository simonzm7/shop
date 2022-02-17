package com.ceiba.users.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.authentication.AuthenticationManager;

@Getter
@AllArgsConstructor
public class LoginUserCommand {

    private String email;
    private String password;
    private AuthenticationManager authenticationManager;

}
