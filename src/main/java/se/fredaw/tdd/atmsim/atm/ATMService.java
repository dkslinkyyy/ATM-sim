package se.fredaw.tdd.atmsim.atm;

import se.fredaw.tdd.atmsim.bank.Account;
import se.fredaw.tdd.atmsim.bank.BankService;
import se.fredaw.tdd.atmsim.bank.transaction.TransactionRequest;
import se.fredaw.tdd.atmsim.bank.transaction.TransactionType;

public class ATMService {

    public void printBalance(Account account){
        System.out.println("Balance: " + account.getBalance());
    }

    public void withdraw(BankService bankService, Account account, int amount) {
        TransactionRequest request = new TransactionRequest(account, amount, TransactionType.WITHDRAW);
        bankService.attemptTransaction(request);
    }

    public void deposit(BankService bankService, Account account, int amount) {
        TransactionRequest request = new TransactionRequest(account, amount, TransactionType.DEPOSIT);
        bankService.attemptTransaction(request);
    }

}
