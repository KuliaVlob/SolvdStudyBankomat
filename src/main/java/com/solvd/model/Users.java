package com.solvd.model;

/**
 * Model class for data base table "Users"
 * 
 * @author Iryna Iemelianova
 */
public class Users {


    private Integer id_user;
    private String login;
    private Double total_amount;


	public Users() {

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_ammount(Double total_amount) {
		this.total_amount = total_amount;
	}

	@Override
	public String toString() {
		return "User: " + getLogin() + ";  " + "Balance : " + getTotal_amount();
	}

}
