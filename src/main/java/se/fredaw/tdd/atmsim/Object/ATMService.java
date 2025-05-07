package se.fredaw.tdd.atmsim.Object;

public class ATMService {

    public void printBalance(Account account){
        System.out.println("Balance: " + account.getBalance());
    }

    //  Simple Function to remove money
    public void withdraw(Account account,  int withdrawAmount){
        if(withdrawAmount <= 0){
            throw new IllegalArgumentException("Amount must be positive"); 
            
        }

        //make account balance transaction
        account.setBalance(account.getBalance() - withdrawAmount);


    }



    // Simple Function to add money
    public void deposit(Account account, int depositAmount){
        if(depositAmount<= 0){
            throw new IllegalArgumentException("Amount must be positive");

        }

        account.setBalance(account.getBalance() + depositAmount);
        System.out.println("Succesfull deposit" + depositAmount);


    }


}
