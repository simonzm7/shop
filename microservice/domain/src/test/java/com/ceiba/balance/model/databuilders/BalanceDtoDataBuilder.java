package com.ceiba.balance.model.databuilders;

import com.ceiba.balance.model.dto.BalanceDto;

import java.math.BigInteger;

public class BalanceDtoDataBuilder {
    private BigInteger id;
    private Double balance;
    public BalanceDtoDataBuilder(){
        this.id = BigInteger.ONE;
        this.balance = 5.0;
    }
    public BalanceDto build(){
        return new BalanceDto(this.id, this.balance);
    }
}
