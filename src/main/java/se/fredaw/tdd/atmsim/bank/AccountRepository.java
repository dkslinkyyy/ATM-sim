package se.fredaw.tdd.atmsim.bank;

public interface AccountRepository {
    Account findById(String accountId);
    boolean doesAccountExist(String accountId);
}


