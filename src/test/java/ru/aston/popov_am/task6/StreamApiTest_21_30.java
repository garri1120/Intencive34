package ru.aston.popov_am.task6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiTest_21_30 {
    private static Stream<Product> s;

    @BeforeEach
    void inti() {
        s = Stream.of(
                new Product("Молоко","Молочные продукты",100),
                new Product("Телевизор","Электроника",35000),
                new Product("Балтика 9","Алкоголь",80),
                new Product("Водка","Алкоголь",260),
                new Product("Йогурт","Молочные продукты",150),
                new Product("Электрочайник","Электроника",3100),
                new Product("Сметана","Молочные продукты",130)
        );
    }


    @Test
    @DisplayName(" 21) Собрать все уникальные элементы Stream в список и отсортировать их ")
    void task_number_21 (){
        List<Integer> integerList = new ArrayList<>(List.of(5,1,6,3,1,4,5));

        integerList.stream()
                .collect(Collectors.groupingBy(
                        x -> x, HashMap::new, Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1 )
                .map(Map.Entry::getKey)
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    @DisplayName(" 22) Собрать элементы Stream в карту, где ключом будет первая буква каждого слова, а значением — само слово. Отсортировать ключи в алфавитном порядке ")
    void task_number_22 (){
        List<String> stringList = new ArrayList<>(List.of("Anna","Tom","Jon","Bob"));

        Map<Character,String> stringMap = stringList.stream()
               .collect(Collectors.toMap(x -> x.charAt(0),x -> x))
               .entrySet()
               .stream()
               .sorted(Map.Entry.comparingByKey())
               .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));

        System.out.println(stringMap);
    }
    @Test
    @DisplayName(" 23) Собрать числа в Stream в список сумм цифр каждого числа ")
    void task_number_23 (){
        List<Integer> integerList = new ArrayList<>(List.of(1234,5555,7776));
        integerList.stream().map(x -> Arrays.stream(Integer.toString(x).split("")).mapToInt(Integer::valueOf).sum()).forEach(System.out::println);
    }

    @Test
    @DisplayName(" 24) Собрать даты в Stream в список, где каждый элемент — это количество дат в каждом месяце года")
    void task_number_24 (){

    }

    @Test
    @DisplayName(" 25) Собрать файлы в Stream в список, где каждый элемент — количество файлов с определенным расширением.")
    void task_number_25 (){

    }

    @Test
    @DisplayName("26) Собрать пользователей в Stream в список объектов, где каждый объект содержит информацию о городе проживания пользователя и количестве пользователей из этого города.")
    void task_number_26 (){

    }

    @Test
    @DisplayName("Собрать продукты в Stream в таблицу, где каждая строка — это информация о продукте (название, категория, стоимость), отсортированную по категории продукта.")
    void task_number_27 (){
        Map<String,List<Product>> productMap  = s
                .collect(Collectors.groupingBy(Product::getCategory))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));

        System.out.println(productMap);
    }

    @Test
    @DisplayName(" 28) Создайте Stream из массива чисел, выведите на экран числа, кратные 3 и 5 одновременно.")
    void task_number_28 (){
        int [] numbers = {3,5,15,21,35,45,60};
        Arrays
                .stream(numbers)
                .filter(x -> x % 3 == 0 && x % 5 == 0)
                .forEach(System.out::println);
    }
    @Test
    @DisplayName(" 29) Создайте два Stream-а: один из массива чисел 1…5, второй из массива 5…10. Объедините эти два Stream-а в один и выведите на экран.")
    void task_number_29 (){
       Stream<Integer> one = Stream.of(1,2,3,4,5);
       Stream<Integer> two = Stream.of(5,6,7,8,9,10);

       Stream
               .concat(one,two)
               .forEach(System.out::println);
    }


    @Test
    @DisplayName(" 30) Создайте Stream-у чисел от 1 до 20. Создайте новый Stream, который будет выводить на экран только четные числа и числа, кратные 3. Затем объедините эти два Stream-a в один и выведите результирующий Stream")
    void task_number_30 (){
        Stream<Integer> one = Stream
                .iterate(1,i -> ++i)
                .limit(20);

        Stream<Integer> two = Stream
                .iterate(1,i -> ++i)
                .limit(20)
                .filter(x -> x % 2 == 0  && x % 3 == 0);


        Stream.concat(one,two)
                .forEach(System.out::println);
    }
}

