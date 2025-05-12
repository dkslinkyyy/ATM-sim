package se.fredaw.tdd.atmsim.repository.impl;

import se.fredaw.tdd.atmsim.bank.User;
import se.fredaw.tdd.atmsim.repository.UserRepository;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        //users.put(user.getId(), user);
    }

    @Override
    public void delete(String id) {
        users.remove(id);
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public boolean doesUserExist(String userId) {
        return users.containsKey(userId);
    }
}
