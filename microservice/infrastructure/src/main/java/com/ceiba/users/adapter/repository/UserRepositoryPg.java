package com.ceiba.users.adapter.repository;

import com.ceiba.infrastructure.jdbc.CustomJdbcTemplate;
import com.ceiba.users.model.entity.LocalUser;
import com.ceiba.users.port.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryPg implements UserRepository {

    private final CustomJdbcTemplate customJdbcTemplate;

    @Override
    public BigInteger save(LocalUser localUser) {
        String sql = "INSERT INTO users(country_id, name, email, password) VALUES(:countryId, :name, :email, :password)";
        return this.customJdbcTemplate.create(sql, localUser);
    }
}
