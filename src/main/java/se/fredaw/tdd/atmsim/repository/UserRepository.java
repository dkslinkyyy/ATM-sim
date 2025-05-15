package se.fredaw.tdd.atmsim.repository;

import se.fredaw.tdd.atmsim.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository implements Repository<User> {
    private final Map<Integer, User> users = new HashMap<>();

    public UserRepository() {
    }

    @Override
    public void save(User entity) {
        users.put(entity.getUserId(), entity);
    }

    @Override
    public void delete(int id) {
        users.remove(id);
    }

    @Override
    public User findById(int id) {
        return users.get(id);
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + users +
                '}';
    }

    public boolean doesUserExist(int userId) {
        return users.containsKey(userId);
    }
}
