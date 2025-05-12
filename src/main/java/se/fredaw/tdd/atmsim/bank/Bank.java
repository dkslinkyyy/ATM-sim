package se.fredaw.tdd.atmsim.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final String name;
    private final List<Account> accounts = new ArrayList<>();


    public Bank(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    //Method for adding an account to the bank
    public void addAccount(Account account){
        accounts.add(account);
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    //Method for seeing if you can find the account in the List
    public Account findAccountbyId(String accountId){
        for (Account account : accounts){
            if (account.getAccountId().equals(accountId)){
                return account;
            }
        }
        return null;
    }

}
