package com.solvd.pojo;

import java.util.Currency;

public class Transaction {

    private Integer amount;
    private Currency currency;
    private Integer banknote;


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Integer getBanknote() {
        return banknote;
    }

    public void setBanknote(Integer banknote) {
        this.banknote = banknote;
    }

}
