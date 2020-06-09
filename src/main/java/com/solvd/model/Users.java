package com.solvd.model;



public class Users {

    private Integer id_user;
    private String login;
    private Double total_ammount;


    public Users() {

    }

    public Users(Integer id_user, String login, Double total_ammount) {

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

    public Double getTotal_ammount() {
        return total_ammount;
    }

    public void setTotal_ammount(Double total_ammount) {
        this.total_ammount = total_ammount;
    }


    @Override
    public String toString() {
        return "User: " + getLogin() + ";  " +
                "Balance : " + getTotal_ammount();
    }


}

