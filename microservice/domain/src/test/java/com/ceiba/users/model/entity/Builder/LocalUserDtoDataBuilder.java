package com.ceiba.users.model.entity.Builder;

import com.ceiba.users.model.dto.LocalUserDto;

import java.math.BigInteger;

public class LocalUserDtoDataBuilder {

    private BigInteger id;
    private String countryId;
    private String name;
    private String email;
    private String password;

    public LocalUserDtoDataBuilder(){
        this.id = BigInteger.valueOf(1);
        this.countryId = "10000000000";
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
                this.password
        );
    }
}
