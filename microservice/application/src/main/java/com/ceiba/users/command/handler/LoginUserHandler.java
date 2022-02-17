package com.ceiba.users.command.handler;


import com.ceiba.handler.CommandResponseHandler;
import com.ceiba.users.command.LoginUserCommand;
import com.ceiba.users.factory.LoginUserFactory;
import com.ceiba.users.service.LoginUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginUserHandler implements CommandResponseHandler<LoginUserCommand, Authentication> {

    private final LoginUserService loginUserService;
    private final LoginUserFactory loginUserFactory;
    @Override
    public Authentication execute(LoginUserCommand command) {
        return this.loginUserService.execute(this.loginUserFactory.toLoginUser(command));
    }
}
