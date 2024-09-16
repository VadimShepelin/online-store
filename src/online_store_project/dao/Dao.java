package online_store_project.dao;

import online_store_project.entity.Order;

import java.util.List;
import java.util.Optional;

public interface Dao<K,T>{
    void add(T t);
    List<T> findAll();
    void delete(K id);
    Optional<T> find(K id);
    T save(T entity);
}
