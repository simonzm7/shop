package com.ceiba.users.databuilder;


import com.ceiba.users.command.UserCommand;

public class UserCommandTestDataBuilder {

    private String countryId;
    private String name;
    private String email;
    private String password;

    public UserCommandTestDataBuilder(){
            this.countryId = "0000000000";
            this.name = "generic name";
            this.email = "generic@generic.com";
            this.password = "123456";
    }

    public UserCommand build(){
        return new UserCommand(
                this.countryId,
                this.name,
                this.email,
                this.password
        );
    }



}
