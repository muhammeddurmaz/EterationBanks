package com.muhammed.eterationbank.service;

import com.muhammed.eterationbank.request.BillTransactionRequest;

public interface BillPaymentTransactionService {
    void payment(BillTransactionRequest transactionRequest);
}
