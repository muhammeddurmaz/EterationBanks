package com.muhammed.eterationbank.service.impl;

import com.muhammed.eterationbank.dto.BankAccountDTO;
import com.muhammed.eterationbank.model.PhoneBillPaymentTransaction;
import com.muhammed.eterationbank.repository.PhoneBillPaymentTransactionRepository;
import com.muhammed.eterationbank.request.PhoneBillPaymentRequest;
import com.muhammed.eterationbank.response.TransactionViewModel;
import com.muhammed.eterationbank.service.AccountService;
import com.muhammed.eterationbank.service.PhoneBillPaymentTransactionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PhoneBillPaymentTransactionServiceImpl implements PhoneBillPaymentTransactionService {
    private static final String TRANSACTION_NAME = "PHONE_BILL_PAYMENT";
    private final PhoneBillPaymentTransactionRepository repository;
    private final AccountService accountService;

    public PhoneBillPaymentTransactionServiceImpl(PhoneBillPaymentTransactionRepository repository, AccountService accountService) {
        this.repository = repository;
        this.accountService = accountService;
    }



    private BankAccountDTO getAccount(String number){
        return accountService.getAccountByAccountNumber(number);
    }

    @Transactional
    @Override
    public TransactionViewModel process(PhoneBillPaymentRequest transaction) {
        BankAccountDTO bankAccountDTO = accountService.debit(transaction.getAmount(), transaction.getAccountNumber());
        PhoneBillPaymentTransaction phoneBillPaymentTransaction = new PhoneBillPaymentTransaction();
        phoneBillPaymentTransaction.setPhoneNumber(transaction.getPhoneNumber());

        phoneBillPaymentTransaction = repository.save(phoneBillPaymentTransaction);
        return new TransactionViewModel()
                .availableBalance(bankAccountDTO.getBalance())
                .accountNumber(bankAccountDTO.getAccountNumber())
                .accountOwner(bankAccountDTO.getOwner())
                .transaction(TRANSACTION_NAME)
                .date(phoneBillPaymentTransaction.getDate())
                .build();
    }
}
