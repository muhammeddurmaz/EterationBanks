package com.muhammed.eterationbank.service;

import com.muhammed.eterationbank.dto.BankAccountDTO;
import com.muhammed.eterationbank.model.DepositTransaction;
import com.muhammed.eterationbank.repository.DepositTransactionRepository;
import com.muhammed.eterationbank.request.TransactionRequest;
import com.muhammed.eterationbank.response.TransactionViewModel;
import com.muhammed.eterationbank.service.impl.AccountServiceImpl;
import com.muhammed.eterationbank.service.impl.DepositTransactionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DepositTransactionServiceTest {
    private TransactionRequest request;
    private DepositTransaction depositTransaction;
    private BankAccountDTO creditBankAccount;

    @Mock
    private DepositTransactionRepository depositTransactionRepository;
    @Mock
    private AccountServiceImpl accountService;
    @InjectMocks
    private DepositTransactionServiceImpl depositTransactionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        request = DataGenerator.createTransactionRequest();
        depositTransaction = DataGenerator.createDepositTransaction();
        creditBankAccount = DataGenerator.createCreditAccount();
    }

    @Test
    public void testProcess() {

        // AccountService.debit metodunun çağrıldığını doğrula
        Mockito.when(accountService.credit(request.getAmount(), request.getAccountNumber())).thenReturn(creditBankAccount);

        Mockito.when(depositTransactionRepository.save(Mockito.any(DepositTransaction.class))).thenReturn(depositTransaction);

        // islemi gerçekleştirir
        TransactionViewModel viewModel = depositTransactionService.process(request);

        assertEquals(viewModel.getAvailableBalance(),creditBankAccount.getBalance());

        // kontrol
        Mockito.verify(accountService).credit(request.getAmount(),request.getAccountNumber());

        // kontrol
        Mockito.verify(depositTransactionRepository).save(Mockito.any(DepositTransaction.class));
    }
}
