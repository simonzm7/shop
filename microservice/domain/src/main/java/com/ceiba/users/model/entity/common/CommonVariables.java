package com.ceiba.users.model.entity.common;

public class CommonVariables {


    public static final int PWD_MIN_LENGTH = 6;
    public static final String MIN_PWD_ERR_MESSAGE = String.format("Your password must have at least %s characters", PWD_MIN_LENGTH);
    public static final String EMAIL_ERR_MESSAGE = "You must enter a valid email";


    public static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
}
