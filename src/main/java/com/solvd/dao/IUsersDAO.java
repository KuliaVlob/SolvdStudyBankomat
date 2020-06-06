package com.solvd.dao;

import com.solvd.model.Users;

public interface IUsersDAO {

    Users getUsersByLogin(String login);

    Users getUsersAmmount(String login);

}

