package ru.aston.popov_am.task1.Interface;

import ru.aston.popov_am.task1.Model.AutoParts;
import ru.aston.popov_am.task2.ErrorHandler.InvalidDataException;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    void save(AutoParts autoParts) throws InvalidDataException;
    List<AutoParts> sortedOrderList();
    BigDecimal sumOfAllOrders();

}
