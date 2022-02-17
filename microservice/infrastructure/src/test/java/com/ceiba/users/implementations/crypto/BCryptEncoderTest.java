package com.ceiba.users.implementations.crypto;

import com.ceiba.AppMock;
import com.ceiba.domain.exception.LengthException;
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
class BCryptEncoderTest {

    @Autowired
    private BCryptEncoder encoder;

    @Test
    @DisplayName("should throw exception if password is null")
    public void passwordIsNull(){
       assertThrows(RuntimeException.class, () -> this.encoder.encodePassword(null));

    }

    @Test
    @DisplayName("should throw exception if password is less than 6")
    public void passwordIsLessThan(){
        assertThrows(LengthException.class, () -> this.encoder.encodePassword("1234"));
    }

    @Test
    @DisplayName("should encode password and compare")
    public void shouldEncodePasswordAndCompare(){
        final String rawPassword = "0000000000";
        String encodedPwd = this.encoder.encodePassword(rawPassword);
        boolean comparePassword = this.encoder.comparePasswords(rawPassword, encodedPwd);
        assertEquals(true, comparePassword);
    }

}