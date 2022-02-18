package com.ceiba.users.model.dto;

import com.ceiba.balance.model.dto.BalanceDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
public class LocalUserDto {
    private BigInteger id;
    private String countryId;
    private String name;
    private String email;
    private String password;
    private BalanceDto balance;
}
