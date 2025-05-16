package se.fredaw.tdd.atmsim.bank;

import se.fredaw.tdd.atmsim.bank.transaction.Transaction;
import se.fredaw.tdd.atmsim.bank.transaction.TransactionType;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private final String accountId;
    private int balance;

    //Added a List where the transsaction history will go
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(String accountId, int startingBalance) {
        this.accountId = accountId;
        this.balance = startingBalance;
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

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    public List<Transaction> getTransactions() {return transactions;}
}


