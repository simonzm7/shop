package com.ceiba.users.port.repository;

import com.ceiba.users.model.entity.LocalUser;

import java.math.BigInteger;

public interface UserRepository {
    BigInteger save(LocalUser localUser);
}
