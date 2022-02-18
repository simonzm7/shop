package com.ceiba.balance.command.factory;

import com.ceiba.balance.command.BalanceCommand;
import com.ceiba.balance.model.Balance;
import org.springframework.stereotype.Component;

@Component
public class BalanceFactory {

    public Balance toBalance(BalanceCommand command){
        return new Balance(
                command.getId(),
                command.getNewBalance(),
                command.getUserEmail()
        );
    }
}
