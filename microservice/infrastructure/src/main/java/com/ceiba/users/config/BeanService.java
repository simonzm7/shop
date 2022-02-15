package com.ceiba.users.config;


import com.ceiba.users.port.dao.UserDao;
import com.ceiba.users.port.repository.UserRepository;
import com.ceiba.users.service.CreateUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanService {


    @Bean
    public CreateUserService createUserService(UserDao userDao, UserRepository userRepository) {
        return new CreateUserService(userDao, userRepository);
    }
}