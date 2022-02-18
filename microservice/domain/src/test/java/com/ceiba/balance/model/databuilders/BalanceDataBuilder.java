package com.ceiba.balance.model.databuilders;

import com.ceiba.balance.model.Balance;

import java.math.BigInteger;

public class BalanceDataBuilder {
    private BigInteger id;
    private Double newBalance;
    private String userEmail;
    public BalanceDataBuilder(){
        this.id = BigInteger.ONE;
        this.newBalance = 6.0;
        this.userEmail = "email0@email.com";
    }

    public void withBalance(Double balance){
        this.newBalance = balance;
    }

    public Balance build(){
        return new Balance(
                this.id,
                this.newBalance,
                this.userEmail
        );
    }

}
