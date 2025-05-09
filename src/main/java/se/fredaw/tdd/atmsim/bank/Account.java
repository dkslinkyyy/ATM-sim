package se.fredaw.tdd.atmsim.bank;

public class Account {
    private final String accountId;
    private int balance;
    private String pincode;

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
    }

    // Simple Function to add money
    public void deposit(int depositAmount) {
        if (depositAmount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");

        }

        setBalance(getBalance() + depositAmount);
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
}


