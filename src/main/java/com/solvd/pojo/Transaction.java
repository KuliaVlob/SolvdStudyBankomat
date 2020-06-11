package com.solvd.pojo;

public class Transaction {

	private Integer ammount;
	private String currency;
	private Integer banknote;

	public Integer getAmmount() {
		return ammount;
	}

	public void setAmmount(Integer ammount) {
		this.ammount = ammount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getBanknote() {
		return banknote;
	}

	public void setBanknote(Integer banknote) {
		this.banknote = banknote;
	}

    public static class DataATM {
    }
}
