package com.ceiba.balance.adapter.dao;

import com.ceiba.balance.adapter.mapper.BalanceMapper;
import com.ceiba.balance.model.dto.BalanceDto;
import com.ceiba.balance.port.dao.BalanceDao;
import com.ceiba.infrastructure.jdbc.CustomJdbcTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
@RequiredArgsConstructor
public class BalanceDaoPg implements BalanceDao {
    private final CustomJdbcTemplate customJdbcTemplate;


    @Override
    public BalanceDto getBalance(BigInteger userId) {
        String sql = "SELECT id, total_balance FROM balance WHERE user_id = :userId";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("userId", userId);
        return this.customJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sql,  mapSqlParameterSource, new BalanceMapper());
    }
}
