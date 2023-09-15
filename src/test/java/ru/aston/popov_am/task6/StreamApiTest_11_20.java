package ru.aston.popov_am.task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamApiTest_11_20 {
    private static Stream<Person> s;



    @BeforeEach
    void inti() {
        s = Stream.of(
                new Person("Ivan", 20),
                new Person("Sergey", 30),
                new Person("Denis", 60),
                new Person("Alex", 50),
                new Person("Svetlana", 60),
                new Person("Tanya", 60)
        );
    }

    @Test
    @DisplayName(" 11) Выведите на экран только те элементы списка, которые больше заданного числа ")
    void task_number_11(){
        List<Integer> integerList = new ArrayList<>(List.of(4,31,15,1,29,50,8));
        int target = 10;
        integerList
                .stream()
                .filter(x -> x > target)
                .forEach(System.out::println);
    }
    @Test
    @DisplayName(" 12) Отфильтруйте все элементы списка, которые меньше 0 ")
    void task_number_12(){
        List<Integer> integerList = new ArrayList<>(List.of(4,-31,15,1,-29,-50,8));
        integerList
                .stream()
                .filter(x -> x > 0)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName(" 13) Выведите на экран строки, которые начинаются с заданной подстроки ")
    void task_number_13(){
        List<String> stringList = new ArrayList<>(List.of("one two three", "one Two","two one","two three","one Five"));
        String target = "one";
        stringList
                .stream()
                .filter(x -> x.startsWith(target))
                .forEach(System.out::println);
    }

    @Test
    @DisplayName(" 14) Выведите все числа в списке, которые не кратны 2 ")
    void task_number_14(){
        List<Integer> integerList = new ArrayList<>(List.of(4,31,15,1,29,50,8));

        integerList
                .stream()
                .filter(x -> x % 2 != 0)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName(" 15) Отфильтруйте объекты по определенному свойству, например, выведите все записи из базы данных, у которых значение поля равно 1")
    void task_number_15(){

       s
               .filter(x -> x.getAge() == 60)
               .forEach(System.out::println);
    }

    @Test
    @DisplayName(" 16) Выведите только те элементы коллекции, которые удовлетворяют определенному условию, например, являются уникальными")
    void task_number_16(){

        List<Integer> integerList = new ArrayList<>(List.of(4,31,28,29,4,15,1,29,50,8,8));

        integerList.stream()
                .collect(Collectors.groupingBy(
                        x -> x, HashMap::new, Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1 )
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName(" 17) Отфильтруйте элементы массива, которые не являются числами")
    void task_number_17() {
        String [] numbers = {"one","2","3","7four","5"};
        Arrays
                .stream(numbers)
                .filter(x -> x.matches("\\d+"))
                .forEach(System.out::println);
    }

    @Test
    @DisplayName(" 18) Выведите на экран элементы списка, которые не входят в другой список")
    void task_number_18() {
        List<Integer> integerList = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
        List<Integer> integerList1 = new ArrayList<>(List.of(17,2,33,4,54,6));

        integerList1
                .stream()
                .filter(x -> !integerList.contains(x))
                .forEach(System.out::println);

    }

    @Test
    @DisplayName(" 19) Проверить, все ли числа в массиве [0, 1, …, 19] являются четными")
    void task_number_19() {
       int [] numbers = {1,2,3,4,5};
       int [] numbers1 = {6,2,8,4};

       boolean res =  Arrays
               .stream(numbers)
               .allMatch(x -> x % 2 == 0);

        boolean res1 =  Arrays
                .stream(numbers1)
                .allMatch(x -> x % 2 == 0);

        Assertions.assertFalse(res);
        Assertions.assertTrue(res1);

    }
    @Test
    @DisplayName(" 20) Проверить, есть ли четное число в списке [0, 1, 2, 3]")
    void task_number_20() {
        List<Integer> integerList = new ArrayList<>(List.of(1,2,3,5));
        List<Integer> integerList1 = new ArrayList<>(List.of(1,7,3,5));

        boolean res = integerList
                .stream()
                .anyMatch(x -> x % 2 == 0);

        boolean res1 = integerList1
                .stream()
                .anyMatch(x -> x % 2 == 0);

        Assertions.assertTrue(res);
        Assertions.assertFalse(res1);
    }
}
