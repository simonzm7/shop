package com.ceiba.infrastructure.exception;

public class TechnicalException extends  RuntimeException{
    public TechnicalException(String message){
        super(message);
    }
    public TechnicalException(String message, Throwable e){
        super(message, e);
    }
}
