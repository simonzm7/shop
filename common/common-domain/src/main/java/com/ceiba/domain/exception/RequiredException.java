package com.ceiba.domain.exception;

public class RequiredException extends RuntimeException{
    public RequiredException(String message){
        super(message);
    }
}
