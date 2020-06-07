package com.solvd.pojo;

import java.math.BigDecimal;
import java.util.Currency;

public class Transaction {

    private BigDecimal amount;
    private Currency currency;
    private Integer banknote;


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
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
