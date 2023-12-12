package com.muhammed.eterationbank.service;

import com.muhammed.eterationbank.request.PhoneBillPaymentRequest;
import com.muhammed.eterationbank.response.TransactionViewModel;

public interface PhoneBillPaymentTransactionService{

    TransactionViewModel process(PhoneBillPaymentRequest transaction);
}
