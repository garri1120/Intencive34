package ru.aston.popov_am.task4.Service;

import ru.aston.popov_am.task4.AppError.NotFoundException;
import ru.aston.popov_am.task4.Model.User;
import java.util.List;

public interface UserService<K extends Number> {
    User findUserById(K k) throws NotFoundException;
    boolean deleteUSerById(K k);
    User saveUser(User user);
    boolean updateUser(User user);
    List<User> findAllUser();
}
