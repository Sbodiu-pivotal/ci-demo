package io.pivotal.apac;

public class User {
    private Account account;

    public void setAccount(Account account) {
        this.account = account;
    }
}

class Account {
    private int balance;

    public Account() {
        this.balance = 0;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }
}