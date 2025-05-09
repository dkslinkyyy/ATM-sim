package se.fredaw.tdd.atmsim;

import se.fredaw.tdd.atmsim.bank.Account;

public interface AccountRepository {
    Account findById(String accountId);

    void addAccount(Account account);

    void removeAccount(Account account);
}
