package com.solvd.dao;

import com.solvd.model.Users;
import org.apache.ibatis.annotations.Param;


public interface IUsersDAO {

	Users getUsersByLogin(String login);

	Users getUsersAmmount(String login);

<<<<<<< HEAD

    void updateAmmount(@Param("total_ammount")Double total_ammount,
                       @Param("login")String login);
}
=======
	void updateAmmount(@Param("total_ammount") Double total_ammount, @Param("login") String login);
	
>>>>>>> 6a4d33e5bc27919f863c5d8c2b4c60593b274e36

}
