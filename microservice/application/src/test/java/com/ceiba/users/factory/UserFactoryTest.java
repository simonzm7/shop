package com.ceiba.users.factory;

import com.ceiba.users.command.UserCommand;
import com.ceiba.users.databuilder.UserCommandTestDataBuilder;
import com.ceiba.users.model.entity.LocalUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = UserFactory.class)
class UserFactoryTest {

    @Autowired
    private UserFactory userFactory;

    @Test
    @DisplayName("should create local user object from user command class")
    public void factoryLocalUser(){
        UserCommand command = new UserCommandTestDataBuilder().build();
        LocalUser user = this.userFactory.toLocalUser(command);
        assertEquals(command.getCountryId(), user.getCountryId());
        assertEquals(command.getEmail(), user.getEmail());
        assertEquals(command.getName(), user.getName());
        assertEquals(command.getPassword(), user.getPassword());
    }

}