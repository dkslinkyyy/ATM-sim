package se.fredaw.tdd.atmsim.Object;

public class Account {

    private int balance = 0;

    private String pincode;
    private boolean authenticated = false;

    public Account(String paramPincode) {
        this.pincode = paramPincode;
    }

    public void authenticate(String paramPincode) {
        this.authenticated = pincode.equals(paramPincode);
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

}
