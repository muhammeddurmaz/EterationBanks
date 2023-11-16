package com.muhammed.eterationbank.repository;

import com.muhammed.eterationbank.model.PhoneBillPaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneBillPaymentTransactionRepository extends JpaRepository<PhoneBillPaymentTransaction,Long> {
}
