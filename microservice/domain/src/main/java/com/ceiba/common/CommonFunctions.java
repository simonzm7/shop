package com.ceiba.common;

public class CommonFunctions {
    private static final String EMPTY_ERROR_MESSAGE = "Your %s can not be empty";

    public static final String buildEmptyErrorMessage(String value){
        return String.format(EMPTY_ERROR_MESSAGE, value);
    }
}
