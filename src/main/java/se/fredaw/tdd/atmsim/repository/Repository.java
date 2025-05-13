package se.fredaw.tdd.atmsim.repository;

import se.fredaw.tdd.atmsim.bank.User;

import java.util.List;

public interface Repository<T> {
    void save(T entity);
    void delete(String id);
    T findById(String id);
    List<T> findAll();
}
