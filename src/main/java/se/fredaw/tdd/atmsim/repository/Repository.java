package se.fredaw.tdd.atmsim.repository;

import se.fredaw.tdd.atmsim.bank.User;

import java.util.List;

public interface Repository<T> {
    void save(T entity);
    void delete(int id);
    T findById(int id);
    List<T> findAll();
}
