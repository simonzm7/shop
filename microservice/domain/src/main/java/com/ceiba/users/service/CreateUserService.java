package com.ceiba.users.service;

import com.ceiba.balance.model.Balance;
import com.ceiba.balance.port.repository.BalanceRepository;
import com.ceiba.domain.exception.DuplicatedException;
import com.ceiba.users.model.entity.LocalUser;
import com.ceiba.users.port.dao.UserDao;
import com.ceiba.users.port.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;

@RequiredArgsConstructor
public class CreateUserService {

    private static final String USER_EXISTS_ERR_MESSAGE = "User already exists";

    private final UserDao userDao;
    private final UserRepository userRepository;
    private final BalanceRepository balanceRepository;

    private void validateIfUserExists(String email, String countryId) {
        boolean exists = this.userDao.existsUserByEmailOrCountryId(email, countryId);
        if (exists){
            throw new DuplicatedException(USER_EXISTS_ERR_MESSAGE);
        }

    }

    public BigInteger execute(LocalUser user){
        this.validateIfUserExists(user.getEmail(), user.getCountryId());
        BigInteger id = this.userRepository.save(user);

        Balance balance = new Balance();
        balance.setUserId(id);
        balance.setNewBalance(0.0);

        this.balanceRepository.save(balance);

        return id;
    }
}
