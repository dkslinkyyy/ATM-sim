package se.fredaw.tdd.atmsim.bank;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private final String accountId;
    private int balance;
    private String pincode;

    //Added a List where the transsaction history will go
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(String accountId, String pincode, int startingBalance) {
        this.accountId = accountId;
        this.pincode = pincode;
        this.balance = startingBalance;
    }

    public void withdraw(int withdrawAmount) {
        if (withdrawAmount <= 0) {
            throw new IllegalArgumentException(" Amount must be positive");
        }

        if (withdrawAmount > balance) {
            throw new IllegalArgumentException(" Insufficient funds");
        }

        setBalance(getBalance() - withdrawAmount);
        //Adds the witthdrawal to the transsaction history as a enum type of Withdrawal
        transactions.add(new Transaction(Transaction.Type.WITHDRAWAL, withdrawAmount));
    }

    // Simple Function to add money
    public void deposit(int depositAmount) {
        if (depositAmount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");

        }

        setBalance(getBalance() + depositAmount);
        //Adds the deposit to the transsaction history as a enum type of Desposit
        transactions.add(new Transaction(Transaction.Type.DEPOSIT, depositAmount));
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public boolean checkPin(String inputPin) {
        return this.pincode.equals(inputPin);
    }

    public List<Transaction> getTransactions() {return transactions;}
}


