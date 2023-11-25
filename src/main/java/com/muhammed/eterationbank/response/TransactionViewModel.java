package com.muhammed.eterationbank.response;

import java.time.Instant;

public class TransactionViewModel {
    private String accountNumber;
    private String accountOwner;
    private double availableBalance;
    private String transaction;
    private Instant date;

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public TransactionViewModel accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public TransactionViewModel accountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
        return this;
    }

    public TransactionViewModel availableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
        return this;
    }

    public TransactionViewModel transaction(String transaction) {
        this.transaction = transaction;
        return this;
    }
    public TransactionViewModel date(Instant date) {
        this.date = date;
        return this;
    }

    public TransactionViewModel build() {
        TransactionViewModel viewModel = new TransactionViewModel();
        viewModel.setAccountNumber(this.accountNumber);
        viewModel.setAccountOwner(this.accountOwner);
        viewModel.setAvailableBalance(this.availableBalance);
        viewModel.setTransaction(this.transaction);
        viewModel.setDate(this.date);
        return viewModel;
    }
}


