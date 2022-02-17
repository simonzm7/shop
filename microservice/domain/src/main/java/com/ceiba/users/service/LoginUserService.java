package com.ceiba.users.service;

import com.ceiba.domain.exception.IncorrectCredentials;
import com.ceiba.domain.exception.NotFoundException;
import com.ceiba.users.model.dto.LocalUserDto;
import com.ceiba.users.model.entity.LoginUser;
import com.ceiba.users.port.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.Optional;


@RequiredArgsConstructor
public class LoginUserService implements UserDetailsService {

    private static final String PWD_ERR_MESSAGE = "Your password is incorrect";
    private static final String NOT_FOUND_USER_ERR_MESSAGE = "User not found";

    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws NotFoundException {
        Optional<LocalUserDto> user = this.userDao.findByEmail(username);

        if (!user.isPresent()){
            throw new NotFoundException(NOT_FOUND_USER_ERR_MESSAGE);
        }
        return new User(user.get().getEmail(), user.get().getPassword(), new ArrayList<>());
    }


    public Authentication execute(LoginUser loginUser){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword());
        try{
            return loginUser.getAuthenticationManager().authenticate(authenticationToken);
        }catch (BadCredentialsException e){
            throw new IncorrectCredentials(PWD_ERR_MESSAGE);
        }
    }
}
