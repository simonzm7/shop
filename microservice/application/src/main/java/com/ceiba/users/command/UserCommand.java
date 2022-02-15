package com.ceiba.users.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCommand {

    private String countryId;
    private String name;
    private String email;
    private String password;
}
