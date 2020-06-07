package com.solvd.model;

import java.util.Currency;

public class Users {
    private Integer id_user;
    private String login;
    private Float total_ammount;


    public Users() {

    }

    public Users(Integer id_user, String login, Float total_ammount, Integer currency) {

        this.id_user = id_user;
        this.login = login;
        this.total_ammount = total_ammount;
       
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Float getTotal_ammount() {
        return total_ammount;
    }

    public void setTotal_ammount(Float total_ammount) {
        this.total_ammount = total_ammount;
    }

  

    @Override
    public String toString() {
        return "Users login: " + getLogin() +
                "Total_ammount: " + getTotal_ammount();
    }


}

