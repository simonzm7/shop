package com.ceiba.users.adapter.repository;

import com.ceiba.infrastructure.jdbc.CustomJdbcTemplate;
import com.ceiba.infrastructure.jdbc.sqlstatement.SqlStatement;
import com.ceiba.users.model.entity.LocalUser;
import com.ceiba.users.port.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
@RequiredArgsConstructor
public class UserRepositoryPg implements UserRepository {

    @SqlStatement(namespace = "user", value ="saveUser")
    private static String sqlSave;

    private final CustomJdbcTemplate customJdbcTemplate;

    @Override
    public BigInteger save(LocalUser localUser) {
        return this.customJdbcTemplate.create(sqlSave, localUser);
    }
}
