package com.ceiba.balance.model.dto;

import com.ceiba.balance.model.databuilders.BalanceDtoDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class BalanceDtoTest {


    @Test
    @DisplayName("should create Balance Dto")
    void balanceDto(){
        BalanceDto balanceDto = new BalanceDtoDataBuilder().build();
        assertEquals(BigInteger.ONE, balanceDto.getId());
        assertEquals(5.0, balanceDto.getBalance());
    }
}