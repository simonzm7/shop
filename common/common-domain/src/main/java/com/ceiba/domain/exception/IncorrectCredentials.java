package com.ceiba.domain.exception;

public class IncorrectCredentials extends  RuntimeException{
    public IncorrectCredentials(String message){
        super(message);
    }
}
