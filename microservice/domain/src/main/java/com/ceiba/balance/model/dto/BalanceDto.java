package com.ceiba.balance.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BalanceDto {
    private BigInteger id;
    private Double balance;

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
