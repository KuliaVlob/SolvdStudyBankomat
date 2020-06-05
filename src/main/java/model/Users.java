package model;

import java.util.Currency;

public class Users {
    private Integer id_user;
    private String login;
    private Float total_ammount;
    private Integer currency;

    public Users() {

    }

    public Users(Integer id_user, String login, Float total_ammount, Integer currency) {

        this.id_user = id_user;
        this.login = login;
        this.total_ammount = total_ammount;
        this.currency = currency;
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

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Users login: " + getLogin() +
                "Total_ammount: " + getTotal_ammount() +
                "Currency: " + getCurrency();
    }


}

