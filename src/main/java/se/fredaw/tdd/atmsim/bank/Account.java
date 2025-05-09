package se.fredaw.tdd.atmsim.bank;

public class Account {


    private int balance;
    private String pincode;
    private boolean authenticated;

    public Account(String pincode, int startingBalance) {
        this.pincode = pincode;
        this.authenticated = false;
        this.balance = startingBalance;
    }

    public void authenticate(String paramPincode) {
            if(!pincode.equals(paramPincode)) {
                this.authenticated = false;
            }
            else{
                this.authenticated = true;
            }
    }


    public void withdraw(int withdrawAmount){
        if (withdrawAmount <= 0){
            throw new IllegalArgumentException(" Amount must be positive");
        }

        if(withdrawAmount > balance){
            throw new IllegalArgumentException(" Insufficient funds");
        }

        balance -= withdrawAmount;

    }

    // Simple Function to add money
    public void  deposit(int depositAmount){
        if(depositAmount<= 0){
            throw new IllegalArgumentException("Amount must be positive");

        }

        System.out.println("Succesfull deposit" + depositAmount);

        balance += depositAmount;

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


