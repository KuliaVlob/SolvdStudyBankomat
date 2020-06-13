package com.solvd.pojo;

public class Transaction {

	private Double amount;
	private String currency;
	private Integer banknote;

	public Double getAmount() {
		return amount;
	}

	public void setAmmount(Double amount) {
		this.amount = amount;
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

}
