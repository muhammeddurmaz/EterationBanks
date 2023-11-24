package com.muhammed.eterationbank.request;

import java.io.Serializable;

public class PhoneBillPaymentRequest extends BillTransactionRequest implements Serializable {
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
