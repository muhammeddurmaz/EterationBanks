package com.muhammed.eterationbank.request;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CreateBankAccountRequest implements Serializable {
    @NotNull
    private String ownerName;
    private String accountNumber;

    public String getOwner() {
        return ownerName;
    }

    public void setOwner(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
