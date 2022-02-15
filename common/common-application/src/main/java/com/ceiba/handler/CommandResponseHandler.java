package com.ceiba.handler;


import org.springframework.transaction.annotation.Transactional;

public interface CommandResponseHandler<T, R> {

    @Transactional
    R execute(T command);
}


