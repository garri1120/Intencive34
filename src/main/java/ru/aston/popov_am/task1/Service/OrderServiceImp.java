package ru.aston.popov_am.task1.Service;

import ru.aston.popov_am.task1.DataSource.OrderList;
import ru.aston.popov_am.task1.Interface.OrderService;
import ru.aston.popov_am.task1.Model.AutoParts;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class OrderServiceImp implements OrderService {
    private final OrderList orderList;

    public OrderServiceImp(OrderList orderList) {
        this.orderList = orderList;
    }

    @Override
    public void save(AutoParts autoParts) {
        orderList.getAutoPartsList().add(autoParts);
    }

    @Override
    public List<AutoParts> sortedOrderList() {
        List<AutoParts> sort = orderList.getAutoPartsList();

        return sort.stream().sorted(Comparator.comparing(x -> x.getUser().getSourName())).toList();
    }
    @Override
    public BigDecimal sumOfAllOrders() {
        return orderList.getAutoPartsList().stream().map(AutoParts::getAutoPartsAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
