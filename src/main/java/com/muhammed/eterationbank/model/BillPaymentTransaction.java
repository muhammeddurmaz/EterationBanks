package com.muhammed.eterationbank.model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BillPaymentTransaction extends Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "payee")
    private String payee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }
}
