package com.muhammed.eterationbank.service.impl;

import com.muhammed.eterationbank.dto.BankAccountDTO;
import com.muhammed.eterationbank.request.TransactionRequest;
import com.muhammed.eterationbank.response.TransactionViewModel;
import com.muhammed.eterationbank.service.AccountService;
import com.muhammed.eterationbank.service.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final AccountService accountService;

    public TransactionServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }



    private BankAccountDTO getAccount(String number){
        return accountService.getAccountByAccountNumber(number);
    }

    @Override
    public TransactionViewModel process(TransactionRequest transaction) {
        return null;
    }
}
