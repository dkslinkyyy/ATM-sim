package se.fredaw.tdd.atmsim.bank;

import se.fredaw.tdd.atmsim.auth.Credentials;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int userId;
    private final String name;
    private final Credentials credentials;
    private final List<Account> accounts;
    public User(int userId, String name, String pincode) {
        this.userId = userId;
        this.name = name;
        this.credentials = new Credentials(userId, pincode);
        this.accounts = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Credentials getCredentials() {
        return credentials;
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
