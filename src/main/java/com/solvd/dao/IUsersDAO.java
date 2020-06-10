package com.solvd.dao;

import com.solvd.model.Users;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface IUsersDAO {

    Users getUsersByLogin(String login);

    Users getUsersAmmount(String login);


    void updateAmmount(@Param("total_ammount")Double total_ammount,
                       @Param("login")String login);
}

