package se.fredaw.tdd.atmsim.Object;

public class ATMService {
    private int balance;

    //Constructor
    public ATMService(int balance) {
        this.balance = balance;
    }

    //Getter & Setter
    private int getBalance() {
        return balance;
    }

    private void setBalance(int balance) {
        this.balance = balance;
    }


    public void printBalance(Account account){
        System.out.println("Balance: " + account.getBalance());
    }

    //  Simple Function to remove money
    public void withdraw(Account account,  int withdrawAmount){
        if(withdrawAmount <= 0){
            throw new IllegalArgumentException("Amount must be positive"); 
            
        }
        if (account.getBalance() < withdrawAmount){
            throw new IllegalArgumentException("Insufficient funds");
        }

        //make account balance transaction
        account.setBalance(account.getBalance() - withdrawAmount);

        //if ATM balance is more than withdrawAmount, a transaction is made
        if(getBalance() > withdrawAmount) {
            setBalance(getBalance() - withdrawAmount);
            System.out.println("Succesfull withdraw " + withdrawAmount);
        }
    }

    @Override
    public String toString() {
        return
                "Your current balance is: " + balance;
    }

    // Simple Function to add money
    public void deposit(Account account, int depositAmount){
        if(depositAmount<= 0){
            throw new IllegalArgumentException("Amount must be positive");

        }

        account.setBalance(account.getBalance() + depositAmount);
        setBalance(getBalance() + depositAmount);
        System.out.println("Succesfull deposit" + depositAmount);


    }


}
