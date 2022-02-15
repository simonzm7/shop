package com.ceiba.users.service;

import com.ceiba.domain.exception.DuplicatedException;
import com.ceiba.users.model.entity.Builder.LocalUserDataBuilder;
import com.ceiba.users.model.entity.LocalUser;
import com.ceiba.users.port.dao.UserDao;
import com.ceiba.users.port.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserServiceTest {

    @Test
    @DisplayName("should throw exception if user exists")
    public void shouldThrowExceptionIfUserExists() {
        LocalUser user = new LocalUserDataBuilder(
                "0000000000",
                "Name",
                "email@email.com",
                "123456"
        ).build();
        UserDao userDao = Mockito.mock(UserDao.class);
        Mockito.when(userDao.existsUserByEmailOrCountryId(user.getEmail(), user.getCountryId())).thenReturn(true);
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        CreateUserService createUserService = new CreateUserService(userDao,  userRepository);
        assertThrows(DuplicatedException.class, () -> createUserService.execute(user));
    }

    @Test
    @DisplayName("should create user if this do not exists")
    public void shouldCreateUserIfThiDoNotExists() {
        LocalUser user = new LocalUserDataBuilder(
                "0000000000",
                "Name",
                "email@email.com",
                "123456"
        ).build();
        BigInteger createdId = BigInteger.valueOf(100);

        UserDao userDao = Mockito.mock(UserDao.class);
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        Mockito.when(userDao.existsUserByEmailOrCountryId(user.getEmail(), user.getCountryId())).thenReturn(false);
        Mockito.when(userRepository.save(user)).thenReturn(createdId);

        CreateUserService createUserService = new CreateUserService(userDao,  userRepository);

        BigInteger idUser = createUserService.execute(user);
        assertEquals(createdId, idUser);
        Mockito.verify(userRepository, Mockito.times(1)).save(user);

    }

}
