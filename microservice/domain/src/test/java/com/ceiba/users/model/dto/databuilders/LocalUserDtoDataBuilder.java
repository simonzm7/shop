package com.ceiba.users.model.dto.databuilders;

import com.ceiba.balance.model.dto.BalanceDto;
import com.ceiba.users.model.dto.LocalUserDto;

import java.math.BigInteger;

public class LocalUserDtoDataBuilder {

    private BigInteger id;
    private String countryId;
    private String name;
    private String email;
    private String password;

    public LocalUserDtoDataBuilder(){
        this.id = BigInteger.ONE;
        this.countryId = "1000000000";
        this.name = "name";
        this.email = "email@email.com";
        this.password = "123456";
    }

    public LocalUserDto build(){
        return new LocalUserDto(
                this.id,
                this.countryId,
                this.name,
                this.email,
                this.password,
                new BalanceDto(BigInteger.ONE, 10.0)
        );
    }
}
