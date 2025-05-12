package se.fredaw.tdd.atmsim.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final String name;
    private final List<Account> accounts = new ArrayList<>();


    public Bank(String name, String pin, int startingBalance) {
        this.name = name;
    }

    public Bank(String testbank) {
        this.name = testbank;
    }

    public String getName() {
        return name;
    }

}
