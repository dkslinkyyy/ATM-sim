package se.fredaw.tdd.atmsim.repository;

import se.fredaw.tdd.atmsim.bank.User;

import java.util.List;

public interface UserRepository {
    void save(User entity);
    void delete(String id);
    User findById(String id);
    List<User> findAll();
}
