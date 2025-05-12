package se.fredaw.tdd.atmsim.bank.repository;

import se.fredaw.tdd.atmsim.bank.User;

import java.util.List;

public class UserRepository implements Repository<User>{
    @Override
    public void save(User entity) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }
}
