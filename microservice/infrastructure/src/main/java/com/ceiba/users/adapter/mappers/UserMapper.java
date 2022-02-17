package com.ceiba.users.adapter.mappers;

import com.ceiba.users.model.dto.LocalUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class UserMapper implements RowMapper<LocalUserDto> {

    @Override
    public LocalUserDto mapRow(ResultSet rs, int rowNum) throws SQLException {

        BigInteger id = BigInteger.valueOf(rs.getInt("id"));
        String countryId = rs.getString("country_id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        String password = rs.getString("password");

        log.info("email: {}", email);

        return new LocalUserDto(
                id,
                countryId,
                name,
                email,
                password
        );
    }
}
