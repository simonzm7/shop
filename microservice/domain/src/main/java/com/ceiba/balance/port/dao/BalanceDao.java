package com.ceiba.balance.port.dao;

import com.ceiba.balance.model.dto.BalanceDto;

import java.math.BigInteger;

public interface BalanceDao {
    BalanceDto getBalance(BigInteger userId);
}
