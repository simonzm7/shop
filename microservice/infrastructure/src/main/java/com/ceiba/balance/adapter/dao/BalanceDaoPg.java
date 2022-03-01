package com.ceiba.balance.adapter.dao;

import com.ceiba.balance.adapter.mapper.BalanceMapper;
import com.ceiba.balance.model.dto.BalanceDto;
import com.ceiba.balance.port.dao.BalanceDao;
import com.ceiba.infrastructure.jdbc.CustomJdbcTemplate;
import com.ceiba.infrastructure.jdbc.sqlstatement.SqlStatement;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
@RequiredArgsConstructor
public class BalanceDaoPg implements BalanceDao {

    @SqlStatement(namespace = "balance", value ="getBalance")
    private static String sqlBalance;

    private final CustomJdbcTemplate customJdbcTemplate;


    @Override
    public BalanceDto getBalance(BigInteger userId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("userId", userId);
        return this.customJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBalance,  mapSqlParameterSource, new BalanceMapper());
    }
}
