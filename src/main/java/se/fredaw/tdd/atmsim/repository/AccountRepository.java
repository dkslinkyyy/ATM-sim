package se.fredaw.tdd.atmsim.bank.repository;

import se.fredaw.tdd.atmsim.bank.Account;

import java.util.HashMap;
import java.util.List;

public class AccountRepository implements Repository<Account> {

    @Override
    public void save(Account entity) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Account findById(String id) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return List.of();
    }
}


