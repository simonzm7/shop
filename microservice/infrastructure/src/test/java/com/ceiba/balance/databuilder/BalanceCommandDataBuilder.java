package com.ceiba.balance.databuilder;

import com.ceiba.balance.command.BalanceCommand;

import java.math.BigInteger;

public class BalanceCommandDataBuilder {
    private BigInteger id;
    private Double newBalance;

    public BalanceCommandDataBuilder(){
        this.id = BigInteger.ONE;
        this.newBalance = 10.0;
    }

    public BalanceCommand build(){
        return new BalanceCommand(
                this.id,
                this.newBalance,
                null
        );
    }
}
