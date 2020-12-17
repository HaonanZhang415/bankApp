package com.haonanzhang415.bankApp.entity;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue()
    private int accountId;
    private String accountType;
    private String accountOpenDate;
    private double balance;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountOpenDate() {
        return accountOpenDate;
    }

    public void setAccountOpenDate(String accountOpenDate) {
        this.accountOpenDate = accountOpenDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
