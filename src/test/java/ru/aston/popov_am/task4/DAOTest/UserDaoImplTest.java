package ru.aston.popov_am.task4.DAOTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.popov_am.task4.DAO.UserDaoImpl;
import ru.aston.popov_am.task4.DataBaseUtil.ConnectionPoolBuilder;
import ru.aston.popov_am.task4.Model.User;
import java.sql.SQLException;
import java.util.Optional;

public class UserDaoImplTest {
    ConnectionPoolBuilder connectionPoolBuilder;
    UserDaoImpl userDao = new UserDaoImpl();

    public UserDaoImplTest() throws SQLException {
    }

    @BeforeEach
    public void beforeEach() throws SQLException {
        connectionPoolBuilder = ConnectionPoolBuilder.create();

    }

    @Test
    public void findAll(){
        Assertions.assertEquals(userDao.findAll().size(), 6);
    }
    @Test
    public void findEntityById(){
        Optional<User>user = Optional.ofNullable(User.builder().id(2).firstname("Дима").lastname("Петров").email("petrov@mail.ru").phone("+79882222222").build());
        Assertions.assertEquals(userDao.findEntityById(2),user);
    }
    @Test
    public void deleteUserById(){
    Assertions.assertTrue(userDao.delete(555));
    }
    @Test
    public void create(){
     User user = User.builder().id(999).firstname("Test").lastname("Test").email("Test@mail.ru").phone("+Test").build();
        Assertions.assertTrue(userDao.create(user));
        userDao.delete(999);
    }
    @Test
    public void update(){
        User user = User.builder().id(999).firstname("Test").lastname("Test").email("Test@mail.ru").phone("+Test").build();
        userDao.create(user);
        User user1 = User.builder().id(999).firstname("Update").lastname("Update").email("Update@mail.ru").phone("+Update").build();
        Assertions.assertTrue(userDao.update(user1));
        userDao.delete(999);
    }
}
