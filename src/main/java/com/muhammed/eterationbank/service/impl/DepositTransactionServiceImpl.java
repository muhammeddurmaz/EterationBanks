package com.muhammed.eterationbank.service.impl;

import com.muhammed.eterationbank.dto.BankAccountDTO;
import com.muhammed.eterationbank.mapper.BankAccountMapper;
import com.muhammed.eterationbank.model.DepositTransaction;
import com.muhammed.eterationbank.repository.DepositTransactionRepository;
import com.muhammed.eterationbank.request.TransactionRequest;
import com.muhammed.eterationbank.response.TransactionViewModel;
import com.muhammed.eterationbank.service.AccountService;
import com.muhammed.eterationbank.service.DepositTransactionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
@Service
public class DepositTransactionServiceImpl implements DepositTransactionService {

    private static final String TRANSACTION_NAME = "DEPOSIT";

    private final DepositTransactionRepository repository;
    private final AccountService accountService;
    private final BankAccountMapper accountMapper;

    public DepositTransactionServiceImpl(DepositTransactionRepository repository, AccountService accountService, BankAccountMapper accountMapper) {
        this.repository = repository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @Override
    @Transactional
    public TransactionViewModel process(TransactionRequest transaction) {
        BankAccountDTO bankAccountDTO = accountService.credit(transaction.getAmount(),transaction.getAccountNumber());

        DepositTransaction depositTransaction = new DepositTransaction();
        depositTransaction.setAmount(transaction.getAmount());
        depositTransaction.setDate(Instant.now());
        depositTransaction.setAccount(accountMapper.toEntity(bankAccountDTO));

        depositTransaction = repository.save(depositTransaction);

        return new TransactionViewModel()
                .availableBalance(bankAccountDTO.getBalance())
                .accountNumber(bankAccountDTO.getAccountNumber())
                .accountOwner(bankAccountDTO.getOwner())
                .transaction(TRANSACTION_NAME)
                .date(depositTransaction.getDate())
                .build();
    }
}
