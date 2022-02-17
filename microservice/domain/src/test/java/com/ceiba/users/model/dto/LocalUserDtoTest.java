package com.ceiba.users.model.dto;

import com.ceiba.users.model.dto.databuilders.LocalUserDtoDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LocalUserDtoTest {

    @Test
    @DisplayName("sould create LocalUser DTO")
    void shouldCreateLocalUserDto(){
        LocalUserDto userDto = new LocalUserDtoDataBuilder().build();
        assertEquals(BigInteger.ONE, userDto.getId());
        assertEquals("1000000000", userDto.getCountryId());
        assertEquals("name", userDto.getName());
        assertEquals("email@email.com", userDto.getEmail());
        assertEquals("123456", userDto.getPassword());
    }

    @Test
    @DisplayName("sould create LocalUser DTO and set new data")
    void shouldCreateLocalUserDtoAndUserSetter(){
        LocalUserDto userDto = new LocalUserDtoDataBuilder().build();
        userDto.setId(BigInteger.TWO);
        userDto.setCountryId("2000000000");
        userDto.setName("name2");
        userDto.setEmail("email1@email.com");
        userDto.setPassword("1234567");
        assertEquals(BigInteger.TWO, userDto.getId());
        assertEquals("2000000000", userDto.getCountryId());
        assertEquals("name2", userDto.getName());
        assertEquals("email1@email.com", userDto.getEmail());
        assertEquals("1234567", userDto.getPassword());
    }

}