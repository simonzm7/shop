package com.ceiba.users.model.entity.Builder;

import com.ceiba.users.model.entity.LocalUser;

public class LocalUserDataBuilder {

    private String countryId;
    private String name;
    private String email;
    private String password;

    public LocalUserDataBuilder(
            String countryId,
            String name,
            String email,
            String password
    ){
        this.countryId = countryId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public LocalUser build(){
        return new LocalUser(
                this.countryId,
                this.name,
                this.email,
                this.password
        );
    }



}
