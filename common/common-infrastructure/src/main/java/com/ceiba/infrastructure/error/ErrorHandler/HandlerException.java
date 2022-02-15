package com.ceiba.infrastructure.error.ErrorHandler;


import com.ceiba.domain.exception.*;
import com.ceiba.infrastructure.exception.TechnicalException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
@Slf4j
public class HandlerException {

    private final String INTERNAL_ERR_MESSAGE = "Internal error, please contact support";

    private static final ConcurrentHashMap<String, Integer> STATUS_CODE = new ConcurrentHashMap<>();

    public HandlerException(){
        STATUS_CODE.put(LengthException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        STATUS_CODE.put(RequiredException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        STATUS_CODE.put(TypeException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        STATUS_CODE.put(NullException.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
        STATUS_CODE.put(DuplicatedException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        STATUS_CODE.put(TechnicalException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception exception){
        String exceptionName = exception.getClass().getSimpleName();
        String exceptionMessage = exception.getMessage();
        Integer statusCode = STATUS_CODE.get(exceptionName);
        Error error;
        Date dateException = new Date();
        if (statusCode == null){
            log.error(exceptionName,exception);
            error = new Error(exceptionName, INTERNAL_ERR_MESSAGE, dateException);
            return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        error = new Error(exceptionName, exceptionMessage, dateException);
        return new ResponseEntity<>(error, HttpStatus.valueOf(statusCode));
    }

}
