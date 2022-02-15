package com.ceiba.handler;


import org.springframework.transaction.annotation.Transactional;

public interface CommandHandler<T> {

    @Transactional
    void execute(T command);
}
