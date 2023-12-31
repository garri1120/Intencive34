package ru.aston.popov_am.task4.DAO;

import ru.aston.popov_am.task4.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao <K extends Number, T> {
    List<T> findAll();
    Optional<T> findEntityById(K k);
    boolean delete(K k);
    User create(T t) ;
    boolean update(T t);
}

