package com.ceiba.users.adapter.dao;

import com.ceiba.infrastructure.jdbc.CustomJdbcTemplate;
import com.ceiba.users.model.entity.LocalUser;
import com.ceiba.users.port.dao.UserDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.math.BigInteger;


@Component
@RequiredArgsConstructor
@Slf4j
public class UserDaoPg implements UserDao {

    private final CustomJdbcTemplate customJdbcTemplate;

    @Override
    public boolean existsUserByEmailOrCountryId(String email, String countryId) {
        String sql = "SELECT count(1) FROM users WHERE email = :email OR country_id = :countryId";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("email", email);
        mapSqlParameterSource.addValue("countryId", countryId);
        return this.customJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .queryForObject(sql, mapSqlParameterSource , Boolean.class);
    }


}
