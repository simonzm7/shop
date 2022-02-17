package com.ceiba.users.implementations.crypto;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import com.ceiba.domain.validation.InputValidation;
@Component
@RequiredArgsConstructor
@Slf4j
public class BCryptEncoder {

    private static final int PASSWORD_LEN = 6;
    private static final String PASSWORD_LEN_MESSAGE = String.format("Password minimum length must be %s", PASSWORD_LEN);
    private static final String PASSWORD_REQUIRED_MESSAGE = "Password can not be null";
    private final BCryptPasswordEncoder encoder;

    public String encodePassword(String rawPassword){
        InputValidation.notNull(rawPassword, PASSWORD_REQUIRED_MESSAGE);
        InputValidation.isMinLength(rawPassword.length(), PASSWORD_LEN, PASSWORD_LEN_MESSAGE);
        return this.encoder.encode(rawPassword);
    }

    public boolean comparePasswords(String rawPassword, String encodedPassword){
        return this.encoder.matches(rawPassword, encodedPassword);
    }
}
