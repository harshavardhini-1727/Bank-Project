package com.harsha.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harsha.bank.model.Account;
import com.harsha.bank.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repo;

    public String save(Account acc) {
        if (repo.existsById(acc.getAccountNumber())) {
            return "Account Number already exists!";
        }
        repo.save(acc);
        return "Account Created Successfully!";
    }

    public int deposit(int accountNumber, int amount) {
        Account acc = repo.findById(accountNumber).orElse(null);
        if (acc == null) {
            return -1;
        }
        acc.deposit(amount);
        repo.save(acc);
        return acc.getBalance();
    }

    public int withdraw(int accountNumber, int amount) {
        Account acc = repo.findById(accountNumber).orElse(null);
        if (acc == null) {
            return -1;
        }
        try {
            acc.withdraw(amount);
            repo.save(acc);
            return acc.getBalance();
        } catch (Exception e) {
            return -2;
        }
    }

    public int getBalance(int accountNumber) {
        Account acc = repo.findById(accountNumber).orElse(null);
        if (acc == null) {
            return -1;
        }
        return acc.getBalance();
    }

    public List<Account> getAllAccounts() {
        return repo.findAll();
    }
}