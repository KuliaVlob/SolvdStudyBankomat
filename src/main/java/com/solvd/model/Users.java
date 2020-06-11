package com.solvd.model;

public class Users {

<<<<<<< HEAD
    private Integer id_user;
    private String login;
    private Double total_ammount;

    public Users() {
=======
	private Integer id_user;
	private String login;
	private Double total_ammount;
>>>>>>> 6a4d33e5bc27919f863c5d8c2b4c60593b274e36

	public Users() {

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
		return "User: " + getLogin() + ";  " + "Balance : " + getTotal_ammount();
	}

}
