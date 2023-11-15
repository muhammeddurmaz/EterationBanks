package com.muhammed.eterationbank.repository;

import com.muhammed.eterationbank.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<BankAccount,Long> {
    Optional<BankAccount> findBankAccountByAccountNumber(String number);

}
