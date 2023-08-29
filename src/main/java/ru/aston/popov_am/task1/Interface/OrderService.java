package ru.aston.popov_am.task1.Interface;

import ru.aston.popov_am.task1.Model.AutoParts;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    void save(AutoParts autoParts);
    List<AutoParts> sortedOrderList();
    BigDecimal sumOfAllOrders();

}
