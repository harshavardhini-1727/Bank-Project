package com.harsha.bank.model;

public class InsufficientBalanceException extends Exception{

    public InsufficientBalanceException(String message)
    {
        super(message);

    }
}
