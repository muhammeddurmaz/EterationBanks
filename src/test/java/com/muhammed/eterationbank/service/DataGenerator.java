package com.muhammed.eterationbank.service;

import com.muhammed.eterationbank.dto.BankAccountDTO;
import com.muhammed.eterationbank.model.BankAccount;
import com.muhammed.eterationbank.model.DepositTransaction;
import com.muhammed.eterationbank.model.PhoneBillPaymentTransaction;
import com.muhammed.eterationbank.model.WithdrawalTransaction;
import com.muhammed.eterationbank.request.CreateBankAccountRequest;
import com.muhammed.eterationbank.request.PhoneBillPaymentRequest;
import com.muhammed.eterationbank.request.TransactionRequest;

public class DataGenerator {
    private static final Long ID = 1L;
    private static final String ACCOUNT_OWNER = "Muhammed";
    private static final String ACCOUNT_NUMBER = "234-234";

    private static final double TRANSACTION_DOUBLE_VALUE = 23.34;
    private static final String BILL_TRANSACTION_PAYEE = "Vodafone";
    private static final double ACCOUNT_BALANCE = 1000.0;
    private static final String PHONE_NUMBER = "05462347890";

    public static CreateBankAccountRequest createBankAccountRequest(){
        CreateBankAccountRequest result = new CreateBankAccountRequest();
        result.setOwner(ACCOUNT_OWNER);
        result.setAccountNumber(ACCOUNT_NUMBER);
        return result;
    }

    public static TransactionRequest createTransactionRequest(){
        TransactionRequest request = new TransactionRequest();
        request.setAmount(TRANSACTION_DOUBLE_VALUE);
        request.setAccountNumber(ACCOUNT_NUMBER);
        return request;
    }


    public static DepositTransaction createDepositTransaction(){
        DepositTransaction depositTransaction = new DepositTransaction();
        depositTransaction.setAmount(TRANSACTION_DOUBLE_VALUE);
        depositTransaction.setId(ID);
        depositTransaction.setAccount(createBankAccount());
        return depositTransaction;
    }
    public static WithdrawalTransaction createWithdrawalTransaction(){
        WithdrawalTransaction withdrawalTransaction = new WithdrawalTransaction();
        withdrawalTransaction.setAmount(TRANSACTION_DOUBLE_VALUE);
        withdrawalTransaction.setId(ID);
        withdrawalTransaction.setAccount(createBankAccount());
        return withdrawalTransaction;
    }

    public static BankAccount createBankAccount(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(ACCOUNT_NUMBER);
        bankAccount.setId(ID);
        bankAccount.setBalance(ACCOUNT_BALANCE);
        return bankAccount;
    }

    public static BankAccountDTO createBankAccountDTO(){
        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        bankAccountDTO.setOwner(ACCOUNT_OWNER);
        bankAccountDTO.setBalance(ACCOUNT_BALANCE);
        bankAccountDTO.setAccountNumber(ACCOUNT_NUMBER);
        return bankAccountDTO;
    }
    public static BankAccountDTO createWithdrawalAccount(){
        BankAccountDTO bankAccountDTO = createBankAccountDTO();
        bankAccountDTO.setBalance(ACCOUNT_BALANCE - TRANSACTION_DOUBLE_VALUE);
        return bankAccountDTO;
    }
    public static BankAccountDTO createCreditAccount(){
        BankAccountDTO bankAccountDTO = createBankAccountDTO();
        bankAccountDTO.setBalance(ACCOUNT_BALANCE + TRANSACTION_DOUBLE_VALUE);
        return bankAccountDTO;

    }

    public static PhoneBillPaymentRequest createPhoneBillPaymentRequest(){
        PhoneBillPaymentRequest paymentRequest = new PhoneBillPaymentRequest();
        paymentRequest.setPayee(BILL_TRANSACTION_PAYEE);
        paymentRequest.setPhoneNumber(PHONE_NUMBER);
        paymentRequest.setAmount(TRANSACTION_DOUBLE_VALUE);
        paymentRequest.setAccountNumber(ACCOUNT_NUMBER);
        return paymentRequest;
    }

    public static PhoneBillPaymentTransaction createPhoneBillPaymentTransaction(){
        PhoneBillPaymentTransaction transaction = new PhoneBillPaymentTransaction();
        transaction.setPhoneNumber(PHONE_NUMBER);
        transaction.setAccount(createBankAccount());
        transaction.setAmount(TRANSACTION_DOUBLE_VALUE);
        transaction.setPayee(BILL_TRANSACTION_PAYEE);
        transaction.setId(ID);
        return transaction;
    }

}
