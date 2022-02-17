package com.ceiba.users.implementations.jwt;

import com.ceiba.AppMock;
import com.ceiba.infrastructure.exception.TechnicalException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes= AppMock.class)
class JwtUtilTest {

    @Autowired
    private JwtUtil jwtUtil;

    @Test
    @DisplayName("should throw exception if  jwt token is invalid")
    void shouldThrowExceptionIfTokenIsInvalid(){
        final String email = "email@email.com";
        final String invalidToken = "invalid_token";
        assertThrows(TechnicalException.class, () -> this.jwtUtil.getUsername(invalidToken));
    }

    @Test
    @DisplayName("should create jwt token")
    void shouldCreateJwtToken(){
        final String email = "email@email.com";
        String token = this.jwtUtil.createJwtToken(email, "https://localhost:/");
        String usernameDecoded = this.jwtUtil.getUsername(token);
        assertEquals(email, usernameDecoded);
    }
}