package ru.aston.popov_am.task4.DAO;

import ru.aston.popov_am.task4.AppError.InvalidDataException;

import java.util.List;
import java.util.Optional;

public interface OrderDao<K extends Number, T> {
    List<T> findAll();
    Optional<T> findEntityById(K k);
    boolean delete(K k);
    boolean create(T t) throws InvalidDataException;
    boolean update(T t) throws InvalidDataException;
}
