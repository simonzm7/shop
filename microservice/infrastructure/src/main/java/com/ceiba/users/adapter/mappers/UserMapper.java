package com.ceiba.users.adapter.mappers;

import com.ceiba.users.model.dto.LocalUserDto;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<LocalUserDto> {

    @Override
    public LocalUserDto mapRow(ResultSet rs, int rowNum) throws SQLException {

        BigInteger id = BigInteger.valueOf(rs.getInt("id"));
        String countryId = rs.getString("country_id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        String password = rs.getString("password");

        return new LocalUserDto(
                id,
                countryId,
                name,
                email,
                password,
                null
        );
    }
}
