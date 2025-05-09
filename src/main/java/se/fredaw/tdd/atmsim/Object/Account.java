package se.fredaw.tdd.atmsim.Object;

import java.util.Scanner;

public class Account {




    private int balance;

    private String pincode;
    private boolean authenticated = false;

    public Account(String paramPincode) {
        this.pincode = paramPincode;
    }

    private void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPincode() {
        return pincode;
    }

    public void authenticate(String paramPincode) {
            if(!pincode.equals(paramPincode)) {
                this.authenticated = false;
            }
            else{
                this.authenticated = true;
            }

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


    @Override
    public String toString() {
        return "Your remaining balance is: " + balance;
    }

    public boolean isAuthenticated() {
        return authenticated;
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


