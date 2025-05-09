package se.fredaw.tdd.atmsim.atm;

import se.fredaw.tdd.atmsim.bank.Account;

public class ATMService {

    public void printBalance(Account account){
        System.out.println("Balance: " + account.getBalance());
    }

    public void withdraw(Account account, int amount){
        try {
            account.withdraw(amount);
            System.out.println("Amount withdrawn: " + amount);
        }
        catch (IllegalArgumentException e){
            System.out.println("The withdraw failed due to an error" + e.getMessage());
        }
    }

    public void deposit (Account account, int amount ){
        try{
            account.deposit(amount);
            System.out.println("Amount deposited: " + amount);
        }
        catch (IllegalArgumentException e){
            System.out.println("The deposit failed due to an error" + e.getMessage());
        }
    }

}
