package com.muhammed.eterationbank.service.impl;

import com.muhammed.eterationbank.dto.BankAccountDTO;
import com.muhammed.eterationbank.exception.AccountNotFound;
import com.muhammed.eterationbank.exception.InsufficientBalanceException;
import com.muhammed.eterationbank.mapper.BankAccountMapper;
import com.muhammed.eterationbank.model.BankAccount;
import com.muhammed.eterationbank.repository.AccountRepository;
import com.muhammed.eterationbank.request.CreateBankAccountRequest;
import com.muhammed.eterationbank.response.AccountViewModel;
import com.muhammed.eterationbank.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final BankAccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, BankAccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }


    @Override
    public BankAccountDTO getAccountByAccountNumber(String number) {
        return accountRepository.findBankAccountByAccountNumber(number)
                .map(accountMapper::toDto)
                .orElseThrow(()-> new AccountNotFound("Account could not found by account number " + number));
    }

    @Override
    public BankAccountDTO update(BankAccountDTO dto) {
        BankAccount account = accountRepository.save(accountMapper.toEntity(dto));
        return accountMapper.toDto(account);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BankAccountDTO debit(double amount, String accountNumber) {
        BankAccountDTO accountDTO = getAccountByAccountNumber(accountNumber);
        double balance = accountDTO.getBalance();
        if(balance >= amount){
            balance = balance - amount;
            accountDTO.setBalance(balance);
        }else {
            throw new InsufficientBalanceException("There are not enough funds for the transaction");
        }

        return this.update(accountDTO);
    }

    @Override
    public BankAccountDTO credit(double amount, String accountNumber) {
        BankAccountDTO accountDTO = getAccountByAccountNumber(accountNumber);
        double balance = accountDTO.getBalance();
        balance = balance + amount;
        accountDTO.setBalance(balance);
        return this.update(accountDTO);
    }

    @Override
    public AccountViewModel getTransactions(String accountNumber) {
        BankAccountDTO bankAccountDTO = getAccountByAccountNumber(accountNumber);

        AccountViewModel accountViewModel = new AccountViewModel()
                .accountNumber(bankAccountDTO.getAccountNumber())
                .owner(bankAccountDTO.getOwner())
                .balance(bankAccountDTO.getBalance())
                .build();
        return accountViewModel;
    }

    @Override
    public BankAccountDTO save(CreateBankAccountRequest request) {
        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        bankAccountDTO.setAccountNumber(request.getAccountNumber());
        bankAccountDTO.setOwner(request.getOwner());
        BankAccount bankAccount = accountMapper.toEntity(bankAccountDTO);
        bankAccount = accountRepository.save(bankAccount);
        return accountMapper.toDto(bankAccount);
    }


}
