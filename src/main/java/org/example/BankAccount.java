package org.example;

public class BankAccount {
    public String accountNumber;
    public String username;
    public double balance;

    public BankAccount(String accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public String toString() {
        return "Account: " + accountNumber + "Name: " + username + "Balance: " + balance;
    }
}