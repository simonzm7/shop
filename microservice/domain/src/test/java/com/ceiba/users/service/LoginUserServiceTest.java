package com.ceiba.users.service;

import com.ceiba.domain.exception.NotFoundException;
import com.ceiba.users.model.dto.LocalUserDto;
import com.ceiba.users.model.entity.Builder.LocalUserDtoDataBuilder;
import com.ceiba.users.port.dao.UserDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LoginUserServiceTest {

    @Test
    @DisplayName("should throw exception if user do not exists")
    public void shouldThrowExceptionIfUserDoNotExists(){

        UserDao userDao = Mockito.mock(UserDao.class);
        Mockito.when(userDao.findByEmail("")).thenReturn(Optional.empty());

        LoginUserService loginUserService = new LoginUserService(userDao);

        assertThrows(NotFoundException.class, ()-> loginUserService.loadUserByUsername(""));
    }

    @Test
    @DisplayName("should return User model if user exists")
    public void shouldReturnUserModelIfUserExists(){

        UserDao userDao = Mockito.mock(UserDao.class);

        LocalUserDto localUserDto = new LocalUserDtoDataBuilder().build();
        Mockito.when(userDao.findByEmail("")).thenReturn(Optional.of(localUserDto));

        LoginUserService loginUserService = new LoginUserService(userDao);

        UserDetails user = loginUserService.loadUserByUsername("");
        assertEquals("email@email.com", user.getUsername());
        assertEquals("123456", user.getPassword());

    }




}