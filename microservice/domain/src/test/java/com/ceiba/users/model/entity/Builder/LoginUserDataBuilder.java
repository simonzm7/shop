package com.ceiba.users.model.entity.Builder;

import com.ceiba.users.model.entity.LoginUser;
import org.springframework.security.authentication.AuthenticationManager;

public class LoginUserDataBuilder {

    private String email;
    private String password;
    private AuthenticationManager authenticationManager;

    public LoginUserDataBuilder(AuthenticationManager authenticationManager){
        this.email = "email@email.com";
        this.password = "123456";
        this.authenticationManager = authenticationManager;
    }

    public void withThisEmail(String newEmail){
        this.email = newEmail;
    }

    public void withThisPassword(String newPassword){
        this.password = newPassword;
    }

    public LoginUser build(){
        return new LoginUser(
                this.email,
                this.password,
                this.authenticationManager
        );
    }
}
