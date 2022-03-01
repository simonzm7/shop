package com.ceiba.balance.adapter.repository;

import com.ceiba.balance.model.Balance;
import com.ceiba.balance.port.repository.BalanceRepository;
import com.ceiba.infrastructure.jdbc.CustomJdbcTemplate;
import com.ceiba.infrastructure.jdbc.sqlstatement.SqlStatement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class BalanceRepositoryPg implements BalanceRepository {

    @SqlStatement(namespace = "balance", value ="saveBalance")
    private static String sqlSaveBalance;

    @SqlStatement(namespace = "balance", value ="updateBalance")
    private static String sqlUpdateBalance;

    private final CustomJdbcTemplate customJdbcTemplate;

    @Override
    public void save(Balance balance) {
        this.customJdbcTemplate.create(sqlSaveBalance, balance);
    }

    @Override
    public void addBalance(Balance balance) {
        this.customJdbcTemplate.update(sqlUpdateBalance, balance);
    }
}
