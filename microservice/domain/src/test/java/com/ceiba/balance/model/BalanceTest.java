package com.ceiba.balance.model;

import com.ceiba.balance.model.databuilders.BalanceDataBuilder;
import com.ceiba.domain.exception.LengthException;
import com.ceiba.domain.exception.RequiredException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class BalanceTest {

    @Test
    @DisplayName("should throw exception if balance is null")
    void balanceIsNull(){
        BalanceDataBuilder balanceDataBuilder = new BalanceDataBuilder();
        balanceDataBuilder.withBalance(null);
        assertThrows(RequiredException.class, () -> balanceDataBuilder.build());
    }

    @Test
    @DisplayName("should throw exception if balance is less than 5.0")
    void balanceIsLessThan(){
        BalanceDataBuilder balanceDataBuilder = new BalanceDataBuilder();
        balanceDataBuilder.withBalance(4.0);
        assertThrows(LengthException.class, () -> balanceDataBuilder.build());
    }

    @Test
    @DisplayName("should create Balance object")
    void createBalance(){
        Balance balance = new BalanceDataBuilder().build();
        assertEquals(BigInteger.ONE, balance.getId());
        assertEquals(6.0, balance.getNewBalance());
        assertEquals("email0@email.com", balance.getUserEmail());
        balance.setUserId(BigInteger.TEN);
        balance.setNewBalance(10.0);
        assertEquals(BigInteger.TEN, balance.getUserId());
        assertEquals(10.0, balance.getNewBalance());
    }
}