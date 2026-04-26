package com.harsha.bank.model;


public class CurrentAccount extends Account
{

  private int overDraftLimit;

  public CurrentAccount(int accountNumber, String accountHolderName, int initialBalance, int overDraftLimit) {
    super(accountNumber, accountHolderName, initialBalance);
    this.overDraftLimit = overDraftLimit;
  }
  

  @Override
  public void withdraw(int amount) throws InsufficientBalanceException
  {
    int currentBalance = checkBalance();
    if(currentBalance + overDraftLimit >= amount)
    {
      int newBalance  = currentBalance - amount;
      updateBalance(newBalance);
      System.out.println("The total Balance is: " + newBalance);

    }
    else {
      throw new InsufficientBalanceException("Withdrawal exceeds overdraft limit");
    }
  }

  @Override
  public void displayDetails()
  {
    super.displayDetails();
    System.out.println("overDraftLimit is " + overDraftLimit);
  }
  

}


  

