package se.fredaw.tdd.atmsim.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class User {
    private final String userId;
    private final String name;
    private final List<Account> accounts;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }
    public void addAccount(Account account) {
        accounts.add(account);
    }
}
