package com.haonanzhang415.bankApp.customer;

public class CustomerAgeException extends RuntimeException{
    public CustomerAgeException() {
        super("age is under 18!!!");
    }
}
