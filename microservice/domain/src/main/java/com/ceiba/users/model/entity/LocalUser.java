package com.ceiba.users.model.entity;

import com.ceiba.common.CommonFunctions;
import com.ceiba.domain.validation.InputValidation;
import com.ceiba.users.model.entity.common.CommonVariables;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Locale;


@Getter
@NoArgsConstructor
public class LocalUser {

    private static final int DNI_MAX_LENGTH = 10;



    private static final String NAME_ERR_MESSAGE = "You must enter a valid name";
    private static final String DNI_LEN_ERR_MESSAGE = String.format("Your national identity must have maximum %s characters", DNI_MAX_LENGTH);

    private static final String NAME_REGEX = "[A-Za-z ]*";



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

        InputValidation.notNull(countryId, CommonFunctions.buildEmptyErrorMessage("national identification"));
        InputValidation.notNull(password, CommonFunctions.buildEmptyErrorMessage("password"));
        InputValidation.notNull(name, CommonFunctions.buildEmptyErrorMessage("name"));
        InputValidation.notNull(email, CommonFunctions.buildEmptyErrorMessage("email"));
        InputValidation.isMaxLength(countryId.length(), DNI_MAX_LENGTH, DNI_LEN_ERR_MESSAGE);
        InputValidation.isMinLength(password.length(), CommonVariables.PWD_MIN_LENGTH, CommonVariables.MIN_PWD_ERR_MESSAGE);
        InputValidation.withRegex(name, NAME_REGEX, NAME_ERR_MESSAGE);
        InputValidation.withRegex(email, CommonVariables.EMAIL_REGEX, CommonVariables.EMAIL_ERR_MESSAGE);

        this.countryId = countryId;
        this.name = name.toLowerCase(Locale.ROOT);
        this.email = email.toLowerCase(Locale.ROOT);
        this.password = password;
    }
}
