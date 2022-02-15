package com.ceiba.users.command.handler;
import com.ceiba.handler.CommandResponseHandler;
import com.ceiba.users.command.UserCommand;
import com.ceiba.users.factory.UserFactory;
import com.ceiba.users.service.CreateUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateUserHandler implements CommandResponseHandler<UserCommand, BigInteger> {

    private final UserFactory userFactory;
    private final CreateUserService createUserService;

    @Override
    public BigInteger execute(UserCommand command) {
        return this.createUserService.execute(this.userFactory.toLocalUser(command));
    }
}
