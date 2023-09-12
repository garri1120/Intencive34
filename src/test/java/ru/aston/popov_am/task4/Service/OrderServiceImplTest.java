package ru.aston.popov_am.task4.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.popov_am.task4.AppError.NotFoundException;
import ru.aston.popov_am.task4.DAO.OrderDaoImpl;
import ru.aston.popov_am.task4.DataBaseUtil.ConnectionPoolBuilder;

import java.sql.SQLException;

public class OrderServiceImplTest {
    ConnectionPoolBuilder connectionPoolBuilder;
    OrderDaoImpl orderDao = new OrderDaoImpl();
    OrderServiceImpl orderService = new OrderServiceImpl(orderDao);

    public OrderServiceImplTest() throws SQLException {
    }

    @BeforeEach
    public void beforeEach() throws SQLException {
        connectionPoolBuilder = ConnectionPoolBuilder.getInstance();

    }
    @Test
    void findUserByIdNotFoundException() {
        Throwable throwable = Assertions.assertThrows(NotFoundException.class, () -> orderService.findOrderById(999));
        Assertions.assertNotNull(throwable.getMessage());
    }
}
