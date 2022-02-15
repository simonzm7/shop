package com.ceiba.users.port.dao;

public interface UserDao {
    boolean existsUserByEmailOrCountryId(String email, String countryId);
}
