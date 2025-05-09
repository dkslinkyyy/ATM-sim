package se.fredaw.tdd.atmsim.Object;

import java.util.Scanner;

public class Account {

    private final String accountId;

    private int balance;
    private final String pincode;
    private boolean authenticated = false;

    public Account(String accountId, String paramPincode) {
        this.accountId = accountId;
        this.pincode = paramPincode;
    }


    public boolean attemptTransaction(TransactionType transactionType, int amount ){
        switch (transactionType){
            case WITHDRAW:
                if(getBalance() < amount){
                    return false;
                }
                return true;
            case DEPOSIT:
                return true;
        }
        return false;
    }

    public String getPincode() {
        return pincode;
    }

    public String getAccountId() {
        return accountId;
    }

    public boolean checkPin(String inputPin) {
        return this.pincode.equals(inputPin);
    }
    @Override
    public String toString() {
        return "Your remaining balance is: " + balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;

    }
    public int getBalance() {
        return balance;
    }
    public enum TransactionType {
        WITHDRAW, DEPOSIT;
    }
}


