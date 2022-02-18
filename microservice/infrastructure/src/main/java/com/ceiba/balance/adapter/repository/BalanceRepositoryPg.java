package com.ceiba.balance.adapter.repository;

import com.ceiba.balance.model.Balance;
import com.ceiba.balance.port.repository.BalanceRepository;
import com.ceiba.infrastructure.jdbc.CustomJdbcTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class BalanceRepositoryPg implements BalanceRepository {

    private final CustomJdbcTemplate customJdbcTemplate;

    @Override
    public void save(Balance balance) {
        String sql = "INSERT INTO balance(total_balance, user_id) VALUES(:newBalance, :userId)";
        this.customJdbcTemplate.create(sql, balance);
    }

    @Override
    public void addBalance(Balance balance) {
        String sql = "UPDATE balance SET total_balance = :newBalance, updated_at = :updatedAt WHERE id = :id AND user_id = :userId";
        this.customJdbcTemplate.update(sql, balance);
    }
}
