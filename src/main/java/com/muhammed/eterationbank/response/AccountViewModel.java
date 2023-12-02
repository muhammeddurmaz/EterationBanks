package com.muhammed.eterationbank.response;

import com.muhammed.eterationbank.model.Transaction;

import java.time.Instant;
import java.util.List;

public class AccountViewModel {
    private String owner;
    private String accountNumber;
    private Instant createdDate;
    private List<AccountTransactionView> transactions;
    private double balance;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public List<AccountTransactionView> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<AccountTransactionView> transactions) {
        this.transactions = transactions;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountViewModel owner(String owner) {
        this.owner = owner;
        return this;
    }

    public AccountViewModel accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public AccountViewModel createdDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public AccountViewModel transactions(List<AccountTransactionView> transactions) {
        this.transactions = transactions;
        return this;
    }

    public AccountViewModel balance(double balance) {
        this.balance = balance;
        return this;
    }

    public AccountViewModel build() {
        AccountViewModel viewModel = new AccountViewModel();
        viewModel.setOwner(this.owner);
        viewModel.setAccountNumber(this.accountNumber);
        viewModel.setCreatedDate(this.createdDate);
        viewModel.setTransactions(this.transactions);
        viewModel.setBalance(this.balance);
        return viewModel;
    }
}
