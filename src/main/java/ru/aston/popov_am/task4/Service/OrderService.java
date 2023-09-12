package ru.aston.popov_am.task4.Service;

import ru.aston.popov_am.task4.AppError.NotFoundException;
import ru.aston.popov_am.task4.Model.Order;

import java.util.List;

public interface OrderService<K extends Number> {
    Order findOrderById(K k) throws NotFoundException;
    boolean deleteOrderById(K k);
    Order saveOrder(Order order);
    boolean updateOrder(Order order);
    List<Order> findAllProduct();
}
