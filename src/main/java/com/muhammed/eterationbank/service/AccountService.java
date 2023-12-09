package com.muhammed.eterationbank.service;

import com.muhammed.eterationbank.dto.BankAccountDTO;
import com.muhammed.eterationbank.request.CreateBankAccountRequest;
import com.muhammed.eterationbank.response.AccountViewModel;

public interface AccountService {

    BankAccountDTO getAccountByAccountNumber(String number);

    BankAccountDTO update(BankAccountDTO dto);

    BankAccountDTO debit(double amount,String accountNumber);

    BankAccountDTO credit(double amount,String accountNumber);

    AccountViewModel getTransactions(String accountNumber);

    BankAccountDTO save(CreateBankAccountRequest request);
}
