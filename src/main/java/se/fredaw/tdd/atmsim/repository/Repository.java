package se.fredaw.tdd.atmsim.bank.repository;

import java.util.List;

public interface Repository<T> {
    void save(T entity);
    void delete(String id);
    T findById(String id);
    List<T> findAll();
}
