package com.ceiba.balance.config;

import com.ceiba.balance.port.dao.BalanceDao;
import com.ceiba.balance.port.repository.BalanceRepository;
import com.ceiba.balance.service.AddBalanceService;
import com.ceiba.users.port.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BalanceBeanService {

    @Bean
    AddBalanceService addBalanceService(UserDao userDao, BalanceDao balanceDao, BalanceRepository balanceRepository){
        return new AddBalanceService(userDao, balanceDao, balanceRepository);
    }
}
