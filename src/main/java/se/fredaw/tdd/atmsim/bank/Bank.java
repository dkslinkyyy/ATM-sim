package se.fredaw.tdd.atmsim.bank;

import se.fredaw.tdd.atmsim.repository.AccountRepository;

import java.util.HashMap;
import java.util.Map;

public class Bank implements AccountRepository {
    private final String name;
    private final Map<String, Account> accounts = new HashMap<>();


    public Bank(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }


}
