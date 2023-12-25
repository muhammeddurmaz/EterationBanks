package com.muhammed.eterationbank.controller;

import com.muhammed.eterationbank.request.TransactionRequest;
import com.muhammed.eterationbank.response.TransactionViewModel;
import com.muhammed.eterationbank.service.DepositTransactionService;
import com.muhammed.eterationbank.service.WithdrawalTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/transaction")
public class TransactionController {

    private final DepositTransactionService depositTransactionService;
    private final WithdrawalTransactionService withdrawalTransactionService;

    public TransactionController(DepositTransactionService transactionService, WithdrawalTransactionService withdrawalTransactionService) {
        this.depositTransactionService = transactionService;
        this.withdrawalTransactionService = withdrawalTransactionService;
    }


    @PostMapping("/credit")
    public ResponseEntity<TransactionViewModel> depositTransaction(@RequestBody TransactionRequest transactionRequest){
        TransactionViewModel result = depositTransactionService.process(transactionRequest);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/debit")
    public ResponseEntity<TransactionViewModel> withdrawalTransaction(@RequestBody TransactionRequest transactionRequest){
       TransactionViewModel result = withdrawalTransactionService.process(transactionRequest);
       return ResponseEntity.ok().body(result);
    }

}
