package com.ceiba.users.adapter.dao;

import com.ceiba.infrastructure.jdbc.CustomJdbcTemplate;
import com.ceiba.users.adapter.mappers.UserMapper;
import com.ceiba.users.model.dto.LocalUserDto;
import com.ceiba.users.port.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
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

    @Override
    public Optional<LocalUserDto> findByEmail(String email) {
        String sql = "SELECT * from users WHERE email = :email";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("email", email);
        return this.customJdbcTemplate.getNamedParameterJdbcTemplate()
                    .query(sql,  parameterSource, new UserMapper())
                .stream().findFirst();

    }
}
