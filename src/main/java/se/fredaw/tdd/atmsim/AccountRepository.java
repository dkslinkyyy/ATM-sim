package se.fredaw.tdd.atmsim;

import se.fredaw.tdd.atmsim.Object.Account;

public interface AccountRepository {
    Account findById(String accountId);
}
