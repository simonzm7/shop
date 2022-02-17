package com.ceiba.users.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCommand {

    private String countryId;
    private String name;
    private String email;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }
}
