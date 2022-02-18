package com.ceiba.users.model.dto;

import com.ceiba.balance.model.dto.BalanceDto;
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
        assertEquals(BigInteger.ONE, userDto.getBalance().getId());
        assertEquals(10.0, userDto.getBalance().getBalance());

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
        userDto.getBalance().setBalance(11.0);
        BalanceDto newBalance = userDto.getBalance();
        userDto.setBalance(newBalance);
        assertEquals(BigInteger.TWO, userDto.getId());
        assertEquals("2000000000", userDto.getCountryId());
        assertEquals("name2", userDto.getName());
        assertEquals("email1@email.com", userDto.getEmail());
        assertEquals("1234567", userDto.getPassword());
        assertEquals(BigInteger.ONE, userDto.getBalance().getId());
        assertEquals(11.0, userDto.getBalance().getBalance());
    }

}