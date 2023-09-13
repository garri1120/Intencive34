package ru.aston.popov_am.task4.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.popov_am.task4.AppError.NotFoundException;
import ru.aston.popov_am.task4.DAO.UserDaoImpl;
import ru.aston.popov_am.task4.DataBaseUtil.ConnectionPoolBuilder;

import java.sql.SQLException;

public class UserServiceImplTest {
    ConnectionPoolBuilder connectionPoolBuilder;
    UserDaoImpl userDao = new UserDaoImpl();
    UserServiceImpl userService = new UserServiceImpl(userDao);
    @BeforeEach
    public void beforeEach() throws SQLException {
        connectionPoolBuilder = ConnectionPoolBuilder.create();

    }
    public UserServiceImplTest() throws SQLException {
    }

    @Test
    void findUserByIdNotFoundException() {
        Throwable throwable = Assertions.assertThrows(NotFoundException.class, () -> userService.findUserById(999));
        Assertions.assertNotNull(throwable.getMessage());
    }
}