package com.ceiba.users.model.entity;

import com.ceiba.domain.validation.InputValidation;
import lombok.Data;

import java.util.Locale;


@Data
public class LocalUser {

    private final int PWD_MIN_LENGTH = 6;
    private final int DNI_MAX_LENGTH = 10;


    private final String EMPTY_ERROR_MESSAGE = "Your %s can not be empty";
    private final String MIN_PWD_ERR_MESSAGE = String.format("Your password must have at least %s characters", this.PWD_MIN_LENGTH);
    private final String EMAIL_ERR_MESSAGE = "You must enter a valid email";
    private final String NAME_ERR_MESSAGE = "You must enter a valid name";
    private final String DNI_LEN_ERR_MESSAGE = String.format("Your national identity must have maximum %s characters", this.DNI_MAX_LENGTH);

    private final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private final String NAME_REGEX = "[A-Za-z ]*";
    private String buildEmptyErrorMessage(String value){
        return String.format(this.EMPTY_ERROR_MESSAGE, value);
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

        InputValidation.notNull(countryId, this.buildEmptyErrorMessage("national identification"));
        InputValidation.notNull(password, this.buildEmptyErrorMessage("password"));
        InputValidation.notNull(name, this.buildEmptyErrorMessage("name"));
        InputValidation.notNull(email, this.buildEmptyErrorMessage("email"));
        InputValidation.isMaxLength(countryId.length(), this.DNI_MAX_LENGTH, this.DNI_LEN_ERR_MESSAGE);
        InputValidation.isMinLength(password.length(), this.PWD_MIN_LENGTH, this.MIN_PWD_ERR_MESSAGE);
        InputValidation.withRegex(name, this.NAME_REGEX, this.NAME_ERR_MESSAGE);
        InputValidation.withRegex(email, this.EMAIL_REGEX, this.EMAIL_ERR_MESSAGE);

        this.countryId = countryId;
        this.name = name.toLowerCase(Locale.ROOT);
        this.email = email.toLowerCase(Locale.ROOT);
        this.password = password;
    }
}
