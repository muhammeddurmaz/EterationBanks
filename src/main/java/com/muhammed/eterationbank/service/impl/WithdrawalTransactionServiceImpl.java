package com.muhammed.eterationbank.service.impl;

import com.muhammed.eterationbank.dto.BankAccountDTO;
import com.muhammed.eterationbank.mapper.BankAccountMapper;
import com.muhammed.eterationbank.model.WithdrawalTransaction;
import com.muhammed.eterationbank.repository.WithdrawalTransactionRepository;
import com.muhammed.eterationbank.request.TransactionRequest;
import com.muhammed.eterationbank.response.TransactionViewModel;
import com.muhammed.eterationbank.service.AccountService;
import com.muhammed.eterationbank.service.WithdrawalTransactionService;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class WithdrawalTransactionServiceImpl implements WithdrawalTransactionService {
    private final static String TRANSACTION_NAME = "WITHDRAWAL";

    private final AccountService accountService;
    private final WithdrawalTransactionRepository repository;
    private final BankAccountMapper accountMapper;

    public WithdrawalTransactionServiceImpl(AccountService accountService, WithdrawalTransactionRepository repository, BankAccountMapper accountMapper) {
        this.accountService = accountService;
        this.repository = repository;
        this.accountMapper = accountMapper;
    }

    @Override
    @Transactional
    public TransactionViewModel process(TransactionRequest transaction) {
        BankAccountDTO bankAccountDTO = accountService.debit(transaction.getAmount(), transaction.getAccountNumber());
        WithdrawalTransaction withdrawalTransaction = new WithdrawalTransaction();
        withdrawalTransaction.setAmount(transaction.getAmount());
        withdrawalTransaction.setAccount(accountMapper.toEntity(bankAccountDTO));
        withdrawalTransaction = repository.save(withdrawalTransaction);
        return new TransactionViewModel()
                .availableBalance(bankAccountDTO.getBalance())
                .accountNumber(bankAccountDTO.getAccountNumber())
                .accountOwner(bankAccountDTO.getOwner())
                .transaction(TRANSACTION_NAME)
                .date(withdrawalTransaction.getDate())
                .build();
    }
}
