package com.ceiba.users.query;

import com.ceiba.balance.model.dto.BalanceDto;
import com.ceiba.balance.port.dao.BalanceDao;
import com.ceiba.users.model.dto.LocalUserDto;
import com.ceiba.users.port.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FetchUserProfileHandler{

    private final UserDao userDao;
    private final BalanceDao balanceDao;

    public Optional<LocalUserDto> execute(String userEmail){
        Optional<LocalUserDto> localUser = this.userDao.findByEmail(userEmail);
        localUser.ifPresent(user -> {
            BalanceDto balanceDto = this.balanceDao.getBalance(user.getId());
            user.setBalance(balanceDto);
            user.setPassword(null);
        });
        return localUser;
    }
}
