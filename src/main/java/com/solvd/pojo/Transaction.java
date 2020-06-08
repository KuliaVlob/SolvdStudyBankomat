package com.solvd.pojo;

import java.math.BigDecimal;
import java.util.Currency;

public class Transaction {

    private BigDecimal amount;
    private String currency;
    private Integer banknote;


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
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
