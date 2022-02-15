package com.ceiba.users.port.dao;

import com.ceiba.users.model.entity.LocalUser;

import java.math.BigInteger;

public interface UserDao {
    boolean existsUserByEmailOrCountryId(String email, String countryId);
}
