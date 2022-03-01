package com.ceiba.users.adapter.dao;

import com.ceiba.infrastructure.jdbc.CustomJdbcTemplate;
import com.ceiba.infrastructure.jdbc.sqlstatement.SqlStatement;
import com.ceiba.users.adapter.mappers.UserMapper;
import com.ceiba.users.model.dto.LocalUserDto;
import com.ceiba.users.port.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class UserDaoPg implements UserDao {

    private final CustomJdbcTemplate customJdbcTemplate;

    @SqlStatement(namespace = "user", value ="userExistsByEmailOrCountryId")
    private static String sqlExists;

    @SqlStatement(namespace = "user", value ="findByEmail")
    private static String sqlFindByEmail;

    @SqlStatement(namespace = "user", value ="userIdByEmail")
    private static String sqlUserIdByEmail;


    @Override
    public boolean existsUserByEmailOrCountryId(String email, String countryId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("email", email);
        mapSqlParameterSource.addValue("countryId", countryId);
        return this.customJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .queryForObject(sqlExists, mapSqlParameterSource , Boolean.class);
    }

    @Override
    public Optional<LocalUserDto> findByEmail(String email) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("email", email);
        return this.customJdbcTemplate.getNamedParameterJdbcTemplate()
                    .query(sqlFindByEmail,  parameterSource, new UserMapper())
                .stream().findFirst();

    }

    @Override
    public BigInteger findUserIdByEmail(String email) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("email", email);
        return this.customJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlUserIdByEmail,  parameterSource, BigInteger.class);
    }
}
