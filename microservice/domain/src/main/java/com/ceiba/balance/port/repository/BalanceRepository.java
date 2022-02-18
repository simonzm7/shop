package com.ceiba.balance.port.repository;

import com.ceiba.balance.model.Balance;

public interface BalanceRepository {
    void save(Balance balance);
    void addBalance(Balance balance);
}
