package com.ceiba.balance.model;

import com.ceiba.common.CommonFunctions;
import com.ceiba.domain.validation.InputValidation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.Date;

@Getter
@NoArgsConstructor
public class Balance {
    private static final Integer MINIUM_VALUE = 5;
    private static final String BALANCE_ERR_MESSAGE = String.format("Your must recharge at least %s USD", MINIUM_VALUE);

    private BigInteger id;
    private Double newBalance;
    private String userEmail;
    private BigInteger userId;
    private Date updatedAt;

    public Balance(
            BigInteger id,
            Double newBalance,
            String userEmail
    ){
        InputValidation.notNull(newBalance, CommonFunctions.buildEmptyErrorMessage("balance"));
        InputValidation.isMinLength(newBalance.intValue(), MINIUM_VALUE, BALANCE_ERR_MESSAGE);
        this.id = id;
        this.newBalance = newBalance;
        this.userEmail = userEmail;
        this.updatedAt = new Date();
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public void setNewBalance(Double newBalance) {
        this.newBalance = newBalance;
    }
}
