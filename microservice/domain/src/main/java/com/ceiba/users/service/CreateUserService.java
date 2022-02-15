package com.ceiba.users.service;

import com.ceiba.domain.exception.DuplicatedException;
import com.ceiba.users.model.entity.LocalUser;
import com.ceiba.users.port.dao.UserDao;
import com.ceiba.users.port.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

@Slf4j
@RequiredArgsConstructor
public class CreateUserService {

    private static final String USER_EXISTS_ERR_MESSAGE = "User already exists";

    private final UserDao userDao;
    private final UserRepository userRepository;

    private void validateIfUserExists(String email, String countryId) {
        boolean exists = this.userDao.existsUserByEmailOrCountryId(email, countryId);
        if (exists){
            throw new DuplicatedException(USER_EXISTS_ERR_MESSAGE);
        }
    }

    public BigInteger execute(LocalUser user){
        this.validateIfUserExists(user.getEmail(), user.getCountryId());
        BigInteger id = this.userRepository.save(user);
        return id;
    }
}
