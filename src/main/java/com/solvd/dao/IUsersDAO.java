package com.solvd.dao;

import com.solvd.model.Users;
import org.apache.ibatis.annotations.Param;


public interface IUsersDAO {

    Users getUsersByLogin(String login);

    Users getUsersAmount(String login);

    void updateAmount(@Param("total_amount") Double total_amount,
                       @Param("login") String login);
}



