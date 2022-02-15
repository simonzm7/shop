package com.ceiba.users.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public class LocalUserDto {
    private BigInteger id;
    private String countryId;
    private String name;
    private String email;
    private String password;
}
