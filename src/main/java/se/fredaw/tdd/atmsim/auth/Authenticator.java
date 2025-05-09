package se.fredaw.tdd.atmsim.auth;

import se.fredaw.tdd.atmsim.bank.AccountRepository;

import se.fredaw.tdd.atmsim.bank.Account;


public class Authenticator {
    private final AccountRepository repository;

    public Authenticator(AccountRepository accountRepository) {
        this.repository = accountRepository ;
    }
    public boolean authenticate(Account account, String inputPin) {
        Account foundAccount = repository.findById(account.getAccountId());
        return foundAccount != null && foundAccount.checkPin(inputPin);
    }
}
