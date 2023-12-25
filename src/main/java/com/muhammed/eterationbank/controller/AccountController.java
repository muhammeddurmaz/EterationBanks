package com.muhammed.eterationbank.controller;

import com.muhammed.eterationbank.dto.BankAccountDTO;
import com.muhammed.eterationbank.request.CreateBankAccountRequest;
import com.muhammed.eterationbank.response.AccountViewModel;
import com.muhammed.eterationbank.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{account-number}")
    public ResponseEntity<BankAccountDTO> getAccount(@PathVariable(name = "account-number") String accountNumber){
        BankAccountDTO dto = accountService.getAccountByAccountNumber(accountNumber);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("")
    public ResponseEntity<BankAccountDTO> saveAccount(@RequestBody @Valid CreateBankAccountRequest request){
        BankAccountDTO savedAccount = accountService.save(request);
        return ResponseEntity.ok().body(savedAccount);
    }

    @GetMapping("/transaction/{account-number}")
    public ResponseEntity<AccountViewModel> getAccountTransaction(@PathVariable(name = "account-number") String accountNumber){
        AccountViewModel viewModel = accountService.getTransactions(accountNumber);
        return ResponseEntity.ok().body(viewModel);
    }
}
