package com.ceiba.domain.validation;


import com.ceiba.domain.exception.LengthException;
import com.ceiba.domain.exception.RequiredException;
import com.ceiba.domain.exception.TypeException;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@NoArgsConstructor
public class InputValidation {


    public static void notNull(Object value, String errorMessage){
        if (value == null || value.toString().isBlank() || value.toString().isEmpty()){
            throw new RequiredException(errorMessage);
        }
    }

    public static void isMinLength(int currentLen, int requiredLen ,String errorMessage){
        if (currentLen < requiredLen){
            throw new LengthException(errorMessage);
        }
    }
    public static void isMaxLength(int currentLen, int requiredLen ,String errorMessage){
        if (currentLen > requiredLen){
            throw new LengthException(errorMessage);
        }
    }

    public static void withRegex(String value, String regex, String errorMessage){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);

        if (!matcher.matches()) {
            throw new TypeException(errorMessage);
        }
    }
}
