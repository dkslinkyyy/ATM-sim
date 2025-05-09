package se.fredaw.tdd.atmsim.atm;

import se.fredaw.tdd.atmsim.bank.Account;

public class ATMService {

    public void printBalance(Account account){
        System.out.println("Balance: " + account.getBalance());
    }

    //ATM -> Kollar om pengar finns på kontot
    //ATM ->

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
