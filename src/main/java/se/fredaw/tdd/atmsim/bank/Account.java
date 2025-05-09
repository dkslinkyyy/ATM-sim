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


