package com.ceiba.users.model.entity;

import com.ceiba.domain.exception.LengthException;
import com.ceiba.domain.exception.RequiredException;
import com.ceiba.domain.exception.TypeException;
import com.ceiba.users.model.entity.Builder.LocalUserDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;


class LocalUserTest {

    @Test
    @DisplayName("Should create LocalUser Object")
    public void shouldInstantiaseLocalUserObject(){
        LocalUser localUser = new LocalUserDataBuilder(
                "0000000000",
                "name",
                "email@email.com",
                "123456"
        ).build();
        assertNotNull(localUser);
        assertNotNull(localUser.getCountryId());
        assertNotNull(localUser.getEmail());
        assertNotNull(localUser.getName());
        assertNotNull(localUser.getPassword());
    }

    @Test
    @DisplayName("should throw exception if country id is null")
    public void shouldThrowExceptionIfCountryIdIsNull(){
        assertThrows(RequiredException.class, () -> new LocalUserDataBuilder(
                null,
                "name",
                "email@email.com",
                "123456"
        ).build());
    }

    @Test
    @DisplayName("should throw exception if country is greather than 10")
    public void shouldThrowExceptionIfCountryIdIsGreatherThan(){
        assertThrows(LengthException.class, () -> new LocalUserDataBuilder(
                "000000000000",
                "name",
                "email@email.com",
                "123456"
        ).build());
    }


    @Test
    @DisplayName("should throw exception if name is null")
    public void shouldThrowExceptionIfNameIsNull(){
        assertThrows(RequiredException.class, () -> new LocalUserDataBuilder(
                "0000000000",
                null,
                "email@email.com",
                "123456"
        ).build());
    }

    @Test
    @DisplayName("should throw exception if name do not contains only letters")
    public void shouldThrowExceptionIfNameHaveNumbers(){
        assertThrows(TypeException.class, () -> new LocalUserDataBuilder(
                "0000000000",
                "name 12 2",
                "email@email.com",
                "123456"
        ).build());
    }

    @Test
    @DisplayName("should throw exception if email is null")
    public void shouldThrowExceptionIfEmailIsNull(){
        assertThrows(RequiredException.class, () -> new LocalUserDataBuilder(
                "0000000000",
                "name",
                null,
                "123456"
        ).build());
    }

    @Test
    @DisplayName("should throw exception if email have invalid format")
    public void shouldThrowExceptionIfEmailHaveInvalidFormat(){
        assertThrows(TypeException.class, () -> new LocalUserDataBuilder(
                "0000000000",
                "name",
                "email",
                "123456"
        ).build());
    }

    @Test
    @DisplayName("should throw exception if password is less than 6")
    public void shouldThrowExceptionIfPasswordIsLessThan(){
        assertThrows(LengthException.class, () -> new LocalUserDataBuilder(
                "0000000000",
                "name",
                "email@email.com",
                "1234"
        ).build());
    }

    @Test
    @DisplayName("should throw exception if password is null")
    public void shouldThrowExceptionIfPasswordIsNull(){
        assertThrows(RequiredException.class, () -> new LocalUserDataBuilder(
                "0000000000",
                "name",
                "email@email.com",
                null
        ).build());
    }
}