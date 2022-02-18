package com.ceiba.balance.adapter.mapper;

import com.ceiba.balance.model.dto.BalanceDto;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceMapper implements RowMapper<BalanceDto> {
    @Override
    public BalanceDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        BigInteger id = BigInteger.valueOf(rs.getLong("id"));
        Double balance = rs.getDouble("total_balance");
        return new BalanceDto(id, balance);
    }
}
