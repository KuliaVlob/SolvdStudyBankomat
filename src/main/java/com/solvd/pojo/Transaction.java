package com.solvd.pojo;


public class Transaction {

    private Integer amount;
    private String currency;
    private Integer banknote;


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
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
