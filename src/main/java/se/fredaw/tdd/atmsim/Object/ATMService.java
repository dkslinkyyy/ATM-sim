package se.fredaw.tdd.atmsim.Object;

public class ATMService {

    //  Simple Function to remove money
    public void withdraw(Account account, int withdrawAmount){
        if(withdrawAmount <= 0){
            throw new IllegalArgumentException("Amount must be positive"); 
            
        }
        if (account.getBalance() < withdrawAmount){
            throw new IllegalArgumentException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - withdrawAmount);

    }


    // Simple Function to add money
    public void deposit(Account account, int depositAmount){
        if(depositAmount<= 0){
            throw new IllegalArgumentException("Amount must be positive");

        }

        account.setBalance(account.getBalance() + depositAmount);

    }
}
