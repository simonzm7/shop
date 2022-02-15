package com.ceiba.users.model.entity;

import com.ceiba.domain.validation.InputValidation;
import lombok.Data;

import java.util.Locale;


@Data
public class LocalUser {

    private static final int PWD_MIN_LENGTH = 6;
    private static final int DNI_MAX_LENGTH = 10;


    private static final String EMPTY_ERROR_MESSAGE = "Your %s can not be empty";
    private static final String MIN_PWD_ERR_MESSAGE = String.format("Your password must have at least %s characters", PWD_MIN_LENGTH);
    private static final String EMAIL_ERR_MESSAGE = "You must enter a valid email";
    private static final String NAME_ERR_MESSAGE = "You must enter a valid name";
    private static final String DNI_LEN_ERR_MESSAGE = String.format("Your national identity must have maximum %s characters", DNI_MAX_LENGTH);

    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String NAME_REGEX = "[A-Za-z ]*";

    private static final String buildEmptyErrorMessage(String value){
        return String.format(EMPTY_ERROR_MESSAGE, value);
    }


    private String countryId;
    private String name;
    private String email;
    private String password;

    public LocalUser(
        String countryId,
        String name,
        String email,
        String password
    ){

        InputValidation.notNull(countryId, buildEmptyErrorMessage("national identification"));
        InputValidation.notNull(password, buildEmptyErrorMessage("password"));
        InputValidation.notNull(name, buildEmptyErrorMessage("name"));
        InputValidation.notNull(email, buildEmptyErrorMessage("email"));
        InputValidation.isMaxLength(countryId.length(), DNI_MAX_LENGTH, DNI_LEN_ERR_MESSAGE);
        InputValidation.isMinLength(password.length(), PWD_MIN_LENGTH, MIN_PWD_ERR_MESSAGE);
        InputValidation.withRegex(name, NAME_REGEX, NAME_ERR_MESSAGE);
        InputValidation.withRegex(email, EMAIL_REGEX, EMAIL_ERR_MESSAGE);

        this.countryId = countryId;
        this.name = name.toLowerCase(Locale.ROOT);
        this.email = email.toLowerCase(Locale.ROOT);
        this.password = password;
    }
}
