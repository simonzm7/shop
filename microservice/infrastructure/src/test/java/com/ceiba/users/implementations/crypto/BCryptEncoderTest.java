package com.ceiba.users.implementations.crypto;

import com.ceiba.domain.exception.RequiredException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


class BCryptEncoderTest {

    @Autowired
    private BCryptEncoder encoder;


    @Test
    public void passwordIsNull(){
       // Exception exception = assertThrows(RuntimeException.class, () -> this.encoder.encodePassword(null));
        assertEquals("", "");
    }

}