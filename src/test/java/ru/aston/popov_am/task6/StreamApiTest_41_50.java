package ru.aston.popov_am.task6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiTest_41_50 {
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
    @DisplayName(" 41) Разделить слова в Stream на две группы по первой букве: гласные и согласные, посчитать количество слов в каждой группе.")
    void task_number_41 (){
        List<String> stringList = new ArrayList<>(List.of("one","two","three","apple","java"));
        stringList
                .stream()
                .collect(Collectors.groupingBy(x -> x.matches("^(?i:[aeiouy]).*"),Collectors.counting()))
                .values()
                .forEach(System.out::println);
    }

    @Test
    @DisplayName(" 42) Разделить числа в Stream на три группы по остатку от деления на 3 (0, 1, 2), посчитать сумму чисел в каждой группе.")
    void task_number_42 (){

    }
    @Test
    @DisplayName(" 43) Разделить даты в Stream на четыре группы по временам года, посчитать количество событий в каждом времени года.")
    void task_number_43 (){

    }
    @Test
    @DisplayName(" 44) Разделить файлы в Stream на два списка: с расширением .txt и с расширением .doc, посчитать количество файлов в каждом списке.")
    void task_number_44 (){

    }
    @Test
    @DisplayName(" 45) Разделить пользователей в Stream на группы по городу (ближний и дальний план), посчитать количество пользователей в каждой группе.")
    void task_number_45 (){

    }
    @Test
    @DisplayName(" 46) Разделить продукты в Stream на несколько групп по категориям , посчитать стоимость продуктов в каждой группе.")
    void task_number_46 (){
        Map<String,Integer> map = s.collect(Collectors.groupingBy(Product::getCategory,Collectors.summingInt(Product::getPrice)));
        System.out.println(map);
    }
    @Test
    @DisplayName(" 47) Создание Stream из массива целых чисел и вывод на экран всех простых чисел в диапазоне от 2 до 100.")
    void task_number_47 (){
        Stream
                .iterate(2,i -> ++i)
                .limit(99)
                .map(BigInteger::valueOf)
                .filter(x -> x.isProbablePrime((int) Math.log((x.intValue()))))
                .forEach(System.out::println);
    }
    @Test
    @DisplayName(" 48) Создание двух Stream из массивов целых чисел и объединение их в один, затем вывод на экран суммы квадратов элементов этого Stream.")
    void task_number_48 (){
     int [] a = {3,4,5}; // 9 + 16 + 25 = 50
     int [] b = {8,9,10}; // 64 + 81 + 100 = 245
     Stream<Integer> aStream = Arrays.stream(a).boxed();
     Stream<Integer> bStream = Arrays.stream(b).boxed();

     int result = Stream.concat(aStream,bStream).map(x -> Math.pow(x,2)).mapToInt(Double::intValue).sum();
     System.out.println(result);
    }

    @Test
    @DisplayName(" 49) Создание трех Stream из массивов и объединение их в один. Затем вывод на экран среднего геометрического значения элементов этого Stream.")
    void task_number_49 (){
        int [] a = {1,2,3};
        int [] b = {4,5,6};
        int [] c = {7,8,9};

        Stream<Integer> aStream = Arrays.stream(a).boxed();
        Stream<Integer> bStream = Arrays.stream(b).boxed();
        Stream<Integer> cStream = Arrays.stream(c).boxed();
        aStream = Stream.concat(aStream,bStream);
        aStream = Stream.concat(aStream,cStream);

        int t = aStream.reduce(1,(x,y) -> x * y);
        int size = a.length + b.length + c.length;

        System.out.println(Math.round(Math.pow(t,1.0/size)));
    }
}
