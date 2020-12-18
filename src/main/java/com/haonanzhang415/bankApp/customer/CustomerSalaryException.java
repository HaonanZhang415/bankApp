package com.haonanzhang415.bankApp.customer;

public class CustomerSalaryException extends RuntimeException{
    public CustomerSalaryException() {
        super("salary is under 30000!!!");
    }
}
