package com.muhammed.eterationbank.request;

import java.io.Serializable;

public class TransactionRequest implements Serializable {
    private double amount;
    private String accountNumber;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
