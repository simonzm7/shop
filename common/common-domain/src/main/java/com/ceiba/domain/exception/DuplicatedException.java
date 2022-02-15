package com.ceiba.domain.exception;

public class DuplicatedException extends  RuntimeException{
    public DuplicatedException(String message){
        super(message);
    }
}
