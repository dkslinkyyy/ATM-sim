package se.fredaw.tdd.atmsim.auth;

import se.fredaw.tdd.atmsim.AccountRepository;
import se.fredaw.tdd.atmsim.Object.Account;

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
