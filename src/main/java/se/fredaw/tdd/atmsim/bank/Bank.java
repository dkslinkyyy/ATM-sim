package se.fredaw.tdd.atmsim.bank;

import se.fredaw.tdd.atmsim.AccountRepository;

import java.util.ArrayList;
import java.util.List;

public class Bank implements AccountRepository {
    private final String name;
    private final List<Account> accounts = new ArrayList<>();


    public Bank(String name, String pin, int startingBalance) {
        this.name = name;


    }

    public String getName() {
        return name;
    }

    @Override
    public Account findById(String accountId) {
        return null;
    }

    @Override
    public void addAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public void removeAccount(Account account) {
        accounts.remove(account);
    }


}
