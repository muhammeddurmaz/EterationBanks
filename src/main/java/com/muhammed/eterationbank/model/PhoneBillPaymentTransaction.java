package com.muhammed.eterationbank.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PhoneBillPaymentTransaction extends BillPaymentTransaction implements Serializable {
    @Column(name = "phone_number")
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
