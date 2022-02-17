package com.ceiba.users.factory;

import com.ceiba.users.command.LoginUserCommand;
import com.ceiba.users.model.entity.LoginUser;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class LoginUserFactory {

    public LoginUser toLoginUser(LoginUserCommand command){
        return new LoginUser(
                command.getEmail(),
                command.getPassword(),
                command.getAuthenticationManager()
        );
    }
}
