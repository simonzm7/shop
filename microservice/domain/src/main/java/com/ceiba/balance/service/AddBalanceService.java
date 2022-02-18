package com.ceiba.balance.service;

import com.ceiba.balance.model.Balance;
import com.ceiba.balance.model.dto.BalanceDto;
import com.ceiba.balance.port.dao.BalanceDao;
import com.ceiba.balance.port.repository.BalanceRepository;
import com.ceiba.users.port.dao.UserDao;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;

@RequiredArgsConstructor
public class AddBalanceService {

    private final UserDao userDao;
    private final BalanceDao balanceDao;
    private final BalanceRepository balanceRepository;

    public void execute(Balance balance){
        BigInteger userId = this.userDao.findUserIdByEmail(balance.getUserEmail());
        balance.setUserId(userId);

        BalanceDto currentBalance = this.balanceDao.getBalance(userId);
        Double newBalance = currentBalance.getBalance() + balance.getNewBalance();
        balance.setNewBalance(newBalance);

        this.balanceRepository.addBalance(balance);
    }
}
