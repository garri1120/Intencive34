package ru.aston.popov_am.task1;
import ru.aston.popov_am.task1.Model.StateOfSupportedAutoParts;
import ru.aston.popov_am.task1.Model.SupportedAutoParts;
import ru.aston.popov_am.task1.Model.User;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class bdf {
//    public static void main(String[] args) {
//        User user1 = new User("Andrew","Ivanov",33);
//        User user2 = new User("Bob","Petrov",33);
//        User user3 = new User("Andrew","Petrov",33);
//        User user4 = new User("Andrew","Sidorov",33);
//        User user5 = new User("Andrew","Pytun",33);
//        User user6  = new User("","Pytun",353);
//        List<User> userList = new ArrayList<>();
//        userList.add(user1);
//        userList.add(user2);
//        userList.add(user3);
//        userList.add(user4);
//        userList.add(user5);
//        userList.add(user6);
//        getAll(userList);
//
//    }
//    public static void getAll(List<User> userList){
//        userList.stream().sorted(Comparator.comparing(User::getSourName)).forEach(System.out::println);
//    }

    public static void main(String[] args) {
        User user1 = new User("Andrew","Ivanov",33);
        SupportedAutoParts supportedAutoParts = new SupportedAutoParts(BigDecimal.valueOf(715),user1,1, StateOfSupportedAutoParts.Very_good_condition);
        double price = supportedAutoParts.getSupportedAutoPartsAmount().doubleValue();
        double  discount = supportedAutoParts.getDiscount().doubleValue();

        System.out.println(discount);
        System.out.println(price);
    }
}
