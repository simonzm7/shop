package com.ceiba.users.model.entity;


import com.ceiba.common.CommonFunctions;
import com.ceiba.domain.validation.InputValidation;
import com.ceiba.users.model.entity.common.CommonVariables;
import lombok.Getter;
import org.springframework.security.authentication.AuthenticationManager;

@Getter
public class LoginUser {

    private final String email;
    private final String password;
    private final AuthenticationManager authenticationManager;

    public LoginUser(
            String email,
            String password,
            AuthenticationManager authenticationManager
    ){
        InputValidation.notNull(password, CommonFunctions.buildEmptyErrorMessage("password"));
        InputValidation.notNull(email, CommonFunctions.buildEmptyErrorMessage("email"));
        InputValidation.isMinLength(password.length(), CommonVariables.PWD_MIN_LENGTH, CommonVariables.MIN_PWD_ERR_MESSAGE);
        InputValidation.withRegex(email, CommonVariables.EMAIL_REGEX, CommonVariables.EMAIL_ERR_MESSAGE);
        this.email = email;
        this.password = password;
        this.authenticationManager = authenticationManager;
    }
}
