package com.ceiba.balance.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BalanceCommand {
    BigInteger id;
    Double newBalance;
    String userEmail;

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
