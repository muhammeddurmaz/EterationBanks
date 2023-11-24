package com.muhammed.eterationbank.request;

import java.io.Serializable;

public class BillTransactionRequest extends TransactionRequest implements Serializable {
    private String payee;

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }
}
