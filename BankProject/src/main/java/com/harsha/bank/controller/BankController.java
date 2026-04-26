package com.harsha.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.harsha.bank.model.Account;
import com.harsha.bank.service.AccountService;

@Controller
public class BankController {

    @Autowired
    private AccountService service;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("accounts", service.getAllAccounts());
        return "index";
    }

    @PostMapping("/createAccount")
    public String createAccount(@ModelAttribute Account acc, RedirectAttributes ra) {
        String result = service.save(acc);
        ra.addFlashAttribute("message", result);
        return "redirect:/";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam int accountNumber,
                          @RequestParam int amount,
                          RedirectAttributes ra) {
        int balance = service.deposit(accountNumber, amount);
        if (balance == -1) {
            ra.addFlashAttribute("message", "Invalid Account Number!");
        } else {
            ra.addFlashAttribute("message", "Deposited! New Balance: " + balance);
        }
        return "redirect:/";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam int accountNumber,
                           @RequestParam int amount,
                           RedirectAttributes ra) {
        int balance = service.withdraw(accountNumber, amount);
        if (balance == -1) {
            ra.addFlashAttribute("message", "Invalid Account Number!");
        } else if (balance == -2) {
            ra.addFlashAttribute("message", "Insufficient Balance!");
        } else {
            ra.addFlashAttribute("message", "Withdrawn! Remaining Balance: " + balance);
        }
        return "redirect:/";
    }

    @PostMapping("/checkBalance")
    public String checkBalance(@RequestParam int accountNumber,
                               RedirectAttributes ra) {
        int balance = service.getBalance(accountNumber);
        if (balance == -1) {
            ra.addFlashAttribute("message", "Invalid Account Number!");
        } else {
            ra.addFlashAttribute("message", "Account Balance: " + balance);
        }
        return "redirect:/";
    }

    @GetMapping("/exit")
    public String exit() {
        return "Exit";
    }
}