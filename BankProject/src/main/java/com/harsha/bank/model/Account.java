package com.harsha.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

    @Id
    private int accountNumber;

    private String accountHolderName;

    private int balance;

   
    public Account() {}

  
    public Account(int accountNumber, String accountHolderName, int initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }


    public void deposit(int amount) {
        if (amount >= 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount");
        }
    }

  
    public void withdraw(int amount) throws InsufficientBalanceException {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn amount is: " + amount);
            } else {
                throw new InsufficientBalanceException("Insufficient Balance");
            }
        } else {
            System.out.println("Invalid amount");
        }
    }


    public int checkBalance() {
        return balance;
    }

  
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }

    protected void updateBalance(int newBalance) {
        balance = newBalance;
    }


    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getBalance() {
        return balance;
    }

    
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}