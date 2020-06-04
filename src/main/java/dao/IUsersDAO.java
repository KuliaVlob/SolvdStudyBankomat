package dao;

import model.Users;

public interface IUsersDAO {

    Users getUsersByLogin(String login);

    Users getUsersAmount(String login);

}

