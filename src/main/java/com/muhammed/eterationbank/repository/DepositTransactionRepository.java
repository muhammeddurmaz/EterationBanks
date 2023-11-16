package com.muhammed.eterationbank.repository;

import com.muhammed.eterationbank.model.DepositTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositTransactionRepository extends JpaRepository<DepositTransaction,Long> {
}
