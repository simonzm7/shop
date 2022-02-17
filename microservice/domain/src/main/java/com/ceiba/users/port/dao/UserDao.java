package com.ceiba.users.port.dao;

import com.ceiba.users.model.dto.LocalUserDto;
import com.ceiba.users.model.entity.LocalUser;

import java.math.BigInteger;
import java.util.Optional;

public interface UserDao {
    boolean existsUserByEmailOrCountryId(String email, String countryId);
    Optional<LocalUserDto> findByEmail(String email);
    BigInteger findUserIdByEmail(String email);
}
