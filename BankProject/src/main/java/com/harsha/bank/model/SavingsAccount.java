package com.harsha.bank.model;


public class SavingsAccount extends Account
{
  private final int  interestRate;

  public SavingsAccount(int accountNumber, String accountHolderName, int initialBalance, int interestRate)
  {
    super(accountNumber, accountHolderName, initialBalance);
    this.interestRate =  interestRate;
  }
  
  public void calculateInterest()
  {
    int currentBalance = checkBalance();
    int interestAmount = (currentBalance * interestRate) / 100;
    deposit(interestAmount);
    System.out.println("Amount is: " + this.checkBalance());
  }

  @Override
  public void displayDetails()
  {
    super.displayDetails();
    System.out.println("Interest Rate is: " + interestRate);
  }
}

