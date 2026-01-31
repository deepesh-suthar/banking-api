package com.deepesh.banking_api.controller;

import com.deepesh.banking_api.entity.Account;
import com.deepesh.banking_api.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    // 1. Create Account
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    // 2. Get Account Balance
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    // 3. Deposit Money
    @PostMapping("/{id}/deposit")
    public Account deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

    // 4. Withdraw Money (NEW)
    @PostMapping("/{id}/withdraw")
    public Account withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }

        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }

    // 5. Transfer Money (NEW)
    @PostMapping("/transfer")
    public void transfer(@RequestBody Map<String, Object> request) {
        Long fromId = Long.parseLong(request.get("fromAccountId").toString());
        Long toId = Long.parseLong(request.get("toAccountId").toString());
        Double amount = Double.parseDouble(request.get("amount").toString());

        Account fromAccount = accountRepository.findById(fromId).orElseThrow(() -> new RuntimeException("Sender not found"));
        Account toAccount = accountRepository.findById(toId).orElseThrow(() -> new RuntimeException("Receiver not found"));

        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
}