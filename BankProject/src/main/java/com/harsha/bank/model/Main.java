package com.harsha.bank.model;

import java.util.Scanner;

public class Main {
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    Bank bank = new Bank();
    
    while(true)
    {
      System.out.println("\n1.Create Account\n2.Deposit\n3.Withdraw\n4.Check Balance\n5.Display\n6.Exit");
      int choice = sc.nextInt();

      switch(choice)
      {
        case 1 -> {
            System.out.println("Enter Acc No:");
            int no = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Name:");
            String name = sc.nextLine();

            System.out.println("Enter Balance:");
            int bal = sc.nextInt();

            Account acc = new Account(no, name, bal);
            bank.createAccount(acc);

            System.out.println("Account Created");
        }

        case 2 -> {
          System.out.println("Enter Account Number:");
          int no = sc.nextInt();

          Account acc = bank.searchAccount(no);

          if(acc == null){
            System.out.println("Account not found");
          }
          else{
            System.out.println("Enter amount:");
            int amt = sc.nextInt();
            acc.deposit(amt);
          }
        }

        case 3 -> {
          System.out.println("Enter Account Number:");
          int no = sc.nextInt();

          Account acc = bank.searchAccount(no);

          if(acc == null){
            System.out.println("Account not found");
          }
          else{
            System.out.println("Enter amount:");
            int amt = sc.nextInt();

            try {
              acc.withdraw(amt);
            } catch(Exception e) {
              System.out.println("Insufficient balance");
            }
          }
        }

        case 4 -> {
          System.out.println("Enter Account Number:");
          int no = sc.nextInt();

          Account acc = bank.searchAccount(no);

          if(acc == null){
            System.out.println("Account not found");
          }
          else{
            System.out.println("Balance: " + acc.checkBalance());
          }
        }

        case 5 -> {
          bank.displayAllAccount();
        }

        case 6 -> {
          System.out.println("Exit");
          sc.close();
          return;
        }
      }
    }
  }
}