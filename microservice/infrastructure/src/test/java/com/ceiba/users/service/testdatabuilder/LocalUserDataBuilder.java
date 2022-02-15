package com.ceiba.users.service.testdatabuilder;

import com.ceiba.users.command.UserCommand;
import com.ceiba.users.model.entity.LocalUser;

public class LocalUserDataBuilder {

        private String countryId;
        private String name;
        private String email;
        private String password;

        public LocalUserDataBuilder(UserCommand command){
            this.countryId = command.getCountryId();
            this.name = command.getName();
            this.email = command.getEmail();
            this.password = command.getPassword();
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
