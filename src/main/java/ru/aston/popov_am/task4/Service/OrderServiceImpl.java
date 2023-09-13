package ru.aston.popov_am.task4.Service;

import ru.aston.popov_am.task4.AppError.InvalidDataException;
import ru.aston.popov_am.task4.AppError.NotFoundException;
import ru.aston.popov_am.task4.DAO.OrderDaoImpl;
import ru.aston.popov_am.task4.Model.Order;
import java.util.List;

public class OrderServiceImpl implements OrderService<Integer> {
   private final OrderDaoImpl orderDaoImpl;

    public OrderServiceImpl(OrderDaoImpl orderDaoImpl) {
        this.orderDaoImpl = orderDaoImpl;
    }

    @Override
    public Order findOrderById(Integer id) throws NotFoundException {
        return orderDaoImpl.findEntityById(id).orElseThrow(()->new NotFoundException("Order c id = " + id + " не найден"));
    }

    @Override
    public boolean deleteOrderById(Integer id) {
        return orderDaoImpl.delete(id);
    }

    @Override
    public Order saveOrder(Order order) {
        try {
           order = orderDaoImpl.create(order);
        } catch (InvalidDataException e) {
            throw new RuntimeException(e);
        }
        return order;
    }

    @Override
    public boolean updateOrder(Order order) {
        try {
            return orderDaoImpl.update(order);
        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Order> findAllProduct() {
        return orderDaoImpl.findAll();
    }
}
