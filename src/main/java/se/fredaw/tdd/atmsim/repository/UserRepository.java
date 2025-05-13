package se.fredaw.tdd.atmsim.repository;

import se.fredaw.tdd.atmsim.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository implements Repository<User> {
    private final Map<String, User> users = new HashMap<>();


    @Override
    public void save(User entity) {
        users.put(entity.getUserId(), entity);
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


    public boolean doesUserExist(String userId) {
        return users.containsKey(userId);
    }
}
