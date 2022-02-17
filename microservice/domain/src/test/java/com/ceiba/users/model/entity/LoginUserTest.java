package com.ceiba.users.model.entity;

import com.ceiba.domain.exception.LengthException;
import com.ceiba.domain.exception.RequiredException;
import com.ceiba.domain.exception.TypeException;
import com.ceiba.users.model.entity.Builder.LoginUserDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


class LoginUserTest {

    @Autowired
    AuthenticationManager authenticationManager;

    @Test
    @DisplayName("should throw exception if email is null")
    public void shouldThrowExceptionIfEmailIsNull(){
        LoginUserDataBuilder loginUserDataBuilder = new LoginUserDataBuilder(
                this.authenticationManager
        );
        loginUserDataBuilder.withThisEmail(null);
        assertThrows(RequiredException.class, () -> loginUserDataBuilder.build());
    }

    @Test
    @DisplayName("should throw exception if password is null")
    public void shouldThrowExceptionIfPasswordIsNull(){
        LoginUserDataBuilder loginUserDataBuilder = new LoginUserDataBuilder(
                this.authenticationManager
        );
        loginUserDataBuilder.withThisPassword(null);
        assertThrows(RequiredException.class, () -> loginUserDataBuilder.build());
    }

    @Test
    @DisplayName("should throw exception if email have invalid format")
    public void shouldThrowExceptionIfEmailHaveInvalidFormat(){
        LoginUserDataBuilder loginUserDataBuilder = new LoginUserDataBuilder(
                this.authenticationManager
        );
        loginUserDataBuilder.withThisEmail("email");
        assertThrows(TypeException.class, () -> loginUserDataBuilder.build());
    }

    @Test
    @DisplayName("should throw exception if password is less than 6")
    public void shouldThrowExceptionIfPasswordIsLessThan(){
        LoginUserDataBuilder loginUserDataBuilder = new LoginUserDataBuilder(
                this.authenticationManager
        );
        loginUserDataBuilder.withThisPassword("1234");
        assertThrows(LengthException.class, () -> loginUserDataBuilder.build());
    }

    @Test
    @DisplayName("Should create LoginUser object")
    public void shouldCreateLoginUserObject(){
        LoginUserDataBuilder loginUserDataBuilder = new LoginUserDataBuilder(
                this.authenticationManager
        );
        LoginUser user = loginUserDataBuilder.build();
        assertEquals("email@email.com", user.getEmail());
        assertEquals("123456", user.getPassword());
        assertEquals(this.authenticationManager, user.getAuthenticationManager());

    }

}