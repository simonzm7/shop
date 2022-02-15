package com.ceiba.users.factory;

import com.ceiba.users.command.UserCommand;
import com.ceiba.users.model.entity.LocalUser;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class UserFactory {


    public LocalUser toLocalUser(UserCommand userCommand){
        return new LocalUser(
                userCommand.getCountryId(),
                userCommand.getName(),
                userCommand.getEmail(),
                userCommand.getPassword()
        );
    }
}
