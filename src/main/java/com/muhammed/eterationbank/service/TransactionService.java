package com.muhammed.eterationbank.service;

import com.muhammed.eterationbank.request.TransactionRequest;
import com.muhammed.eterationbank.response.TransactionViewModel;

public interface TransactionService {
    TransactionViewModel process(TransactionRequest transaction);

}
