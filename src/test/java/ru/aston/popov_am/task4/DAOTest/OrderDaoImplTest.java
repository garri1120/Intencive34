package ru.aston.popov_am.task4.DAOTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.aston.popov_am.task4.AppError.InvalidDataException;
import ru.aston.popov_am.task4.DAO.OrderDaoImpl;
import ru.aston.popov_am.task4.Model.Order;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class OrderDaoImplTest {
    OrderDaoImpl orderDao = Mockito.mock(OrderDaoImpl.class);
    Order order;
    @BeforeEach
    void setUP(){
        order = Order.builder().price(0).product("Car").userId(5).build();
    }

    @Test
    void createOrderInvalidDataException() throws InvalidDataException {
        when(orderDao.create(order)).thenThrow(new InvalidDataException(anyString()));
        Throwable throwable = Assertions.assertThrows(InvalidDataException.class, () -> orderDao.create(order));
        Assertions.assertNotNull(throwable.getMessage());

    }

}
