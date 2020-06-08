package com.solvd.model;


import java.math.*;

public class Users {

    private Integer id_user;
    private String login;
    private BigDecimal total_ammount;


    public Users() {

    }

    public Users(Integer id_user, String login, BigDecimal total_ammount) {

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

    public BigDecimal getTotal_ammount() {
        return total_ammount;
    }

    public void setTotal_ammount(BigDecimal total_ammount) {
        this.total_ammount = total_ammount;
    }

  

    @Override
    public String toString() {
        return "User: " + getLogin() + ";  " +
                "Balance : " + getTotal_ammount();
    }


}

