package com.ceiba.infrastructure.error.ErrorHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Error {

    private String nameExeception;
    private String message;
    private Date timestamp;

}
