package ru.aston.popov_am.task1.ServiceTest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.aston.popov_am.task1.DataSource.OrderList;
import ru.aston.popov_am.task1.Interface.OrderService;
import ru.aston.popov_am.task1.Model.*;
import ru.aston.popov_am.task1.Service.OrderServiceImp;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class OrderServiceImpTest {
    OrderList orderList = new OrderList();
    List<AutoParts> autoPartsList  = initAutoPartList();
    OrderService orderService = initOrderService();
    private List<AutoParts> initAutoPartList(){
        List<AutoParts> autoPartsList = new ArrayList<>();
        User user1 = new User("Андрей", "Иванов",33);
        User user2 = new User("Дмитрий", "Сидоров",47);
        User user3 = new User("Петр", "Алексеев",18);
        User user4 = new User("Василий", "Кротов",24);
        User user5 = new User("Игорь", "Мальцев",64);


        SupportedAutoParts supportedAutoParts1 = new SupportedAutoParts(new BigDecimal(2000),user1,1, StateOfSupportedAutoParts.VERY_GOOD_CONDITION);
        SupportedAutoParts supportedAutoParts2 = new SupportedAutoParts(new BigDecimal(1500),user2,2, StateOfSupportedAutoParts.SATISFACTORY_CONDITION);
        SupportedAutoParts supportedAutoParts3 = new SupportedAutoParts(new BigDecimal(3001),user5,5, StateOfSupportedAutoParts.UNDER_RESTORATION_CONDITION);
        NewAutoParts newAutoParts1 = new NewAutoParts(new BigDecimal(1000),user3,3);
        NewAutoParts newAutoParts2 = new NewAutoParts(new BigDecimal(4500),user4,4);

        autoPartsList.add(supportedAutoParts1);
        autoPartsList.add(supportedAutoParts2);
        autoPartsList.add(supportedAutoParts3);
        autoPartsList.add(newAutoParts1);
        autoPartsList.add(newAutoParts2);
        return autoPartsList;
    }
    private OrderService initOrderService(){
        OrderService orderService = new OrderServiceImp(orderList);
        for(AutoParts autoParts : autoPartsList){
            orderService.save(autoParts);
        }
        return orderService;
    }
    @Test
    void saveOneElementTest(){
        OrderList orderList1 = new OrderList();
        OrderService orderService1 = new OrderServiceImp(orderList1);
        User user = new User("Игорь","Захаров",55);

        SupportedAutoParts supportedAutoParts = new SupportedAutoParts(new BigDecimal(3000),user,1,StateOfSupportedAutoParts.VERY_GOOD_CONDITION);
        orderService1.save(supportedAutoParts);
        Assertions.assertFalse(orderList1.getAutoPartsList().isEmpty());
        Assertions.assertEquals(user,orderList1.getAutoPartsList().get(0).getUser());
    }

    @Test
    void saveTest(){
        Assertions.assertEquals(5,orderList.getAutoPartsList().size());
    }

    @Test
    void sumOfAllOrdersTest(){
        BigDecimal number = new BigDecimal("9850.500");
        Assertions.assertEquals(number,orderService.sumOfAllOrders());
    }

    @Test
    void sortedOrderListTest(){
       List<AutoParts> autoParts = orderService.sortedOrderList();
       Assertions.assertEquals("Мальцев",autoParts.get(3).getUser().getSourName());
    }
}
