package ru.aston.popov_am.task4.DAOTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.popov_am.task4.AppError.InvalidDataException;
import ru.aston.popov_am.task4.DAO.OrderDaoImpl;
import ru.aston.popov_am.task4.DataBaseUtil.ConnectionPoolBuilder;
import ru.aston.popov_am.task4.Model.Order;

import java.sql.SQLException;

public class OrderDaoImplTest {
    ConnectionPoolBuilder connectionPoolBuilder;
    OrderDaoImpl orderDao = new OrderDaoImpl();

    public OrderDaoImplTest() throws SQLException {
    }

    @BeforeEach
    public void beforeEach() throws SQLException {
        connectionPoolBuilder = ConnectionPoolBuilder.getInstance();
    }

    @Test
    void createOrderInvalidDataException() {
        Order order = Order.builder().id(400).price(0).product("Car").build();
        Throwable throwable = Assertions.assertThrows(InvalidDataException.class, () -> orderDao.create(order));
        Assertions.assertNotNull(throwable.getMessage());
    }

}
