package com.solvd.pojo;

public class Transaction {

	private Double ammount;
	private String currency;
	private Integer banknote;

	public Double getAmmount() {
		return ammount;
	}

	public void setAmmount(Double ammount) {
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
