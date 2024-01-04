package com.muhammed.eterationbank.controller;

import com.muhammed.eterationbank.request.PhoneBillPaymentRequest;
import com.muhammed.eterationbank.response.TransactionViewModel;
import com.muhammed.eterationbank.service.PhoneBillPaymentTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/bill-payment")
public class BillPaymentTransactionController {
    private final PhoneBillPaymentTransactionService phoneBillPaymentTransactionService;

    public BillPaymentTransactionController(PhoneBillPaymentTransactionService phoneBillPaymentTransactionService) {
        this.phoneBillPaymentTransactionService = phoneBillPaymentTransactionService;
    }

    @PostMapping("/phone")
    public ResponseEntity<TransactionViewModel> phoneBillPayment(@RequestBody PhoneBillPaymentRequest request){
        TransactionViewModel viewModel = phoneBillPaymentTransactionService.process(request);
        return ResponseEntity.ok().body(viewModel);
    }
}
