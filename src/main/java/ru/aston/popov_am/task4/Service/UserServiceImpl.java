package ru.aston.popov_am.task4.Service;

import ru.aston.popov_am.task4.AppError.NotFoundException;
import ru.aston.popov_am.task4.DAO.UserDaoImpl;
import ru.aston.popov_am.task4.Model.User;

import java.util.List;

public class UserServiceImpl implements UserService<Integer>{
    private final UserDaoImpl userDaoImpl;

    public UserServiceImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    public User findUserById(Integer id) throws NotFoundException{
        return userDaoImpl.findEntityById(id).orElseThrow(()->new NotFoundException("User c id = " + id + " не найден"));
    }

    @Override
    public boolean deleteUSerById(Integer integer) {
        return userDaoImpl.delete(10);
    }

    @Override
    public boolean saveUser(User user) {
       return userDaoImpl.create(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDaoImpl.update(user);
    }

    @Override
    public List<User> findAllUser() {
        return userDaoImpl.findAll();
    }
}
