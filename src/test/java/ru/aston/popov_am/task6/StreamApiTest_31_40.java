package ru.aston.popov_am.task6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiTest_31_40 {
    @Test
    @DisplayName(" 31) Создайте Stream чисел от 2 до 50. Умножьте их на 2 и выведите результат на экран, ограничьтесь первыми десятью результатами.")
    void task_number_31 (){
      Stream
              .iterate(2,i -> ++i)
              .limit(50).map(x -> x*2)
              .limit(10)
              .forEach(System.out::println);
    }

    @Test
    @DisplayName(" 32) Создайте три Stream-а из массивов чисел 1…10, 5…20 и 10…30 соответственно. Объедините их в один Stream и выведите числа, которые кратны 3 или 5.")
    void task_number_32 (){
        Stream<Integer> one = Stream.iterate(1,i -> ++i).limit(10);
        Stream<Integer> two = Stream.iterate(5,i -> ++i).limit(16);
        Stream<Integer> three = Stream.iterate(10,i -> ++i).limit(21);

        one = Stream.concat(one,two);

        Stream
                .concat(one,three)
                .filter(x -> x % 3 == 0 || x % 5 == 0)
                .forEach(System.out::println);

    }

    @Test
    @DisplayName(" 33) Создайте Stream, который выводит на экран четные числа от 2 до 30.")
    void task_number_33 (){
       Stream
               .iterate(2,i -> ++i)
               .limit(29)
               .filter(x-> x % 2 == 0)
               .forEach(System.out::println);
    }

    @Test
    @DisplayName(" 34) Создать стрим из массива чисел и вывести на экран только числа, которые больше 10 и меньше 20.")
    void task_number_34 (){
        Stream
                .iterate(1,i -> ++i)
                .limit(40)
                .filter(x-> x > 10 && x < 20 )
                .forEach(System.out::println);
    }

    @Test
    @DisplayName(" 35) Создать два стрима: один из чисел от 0 до 10, другой из чисел от 10 до 20. Объединить их в один стрим и вывести на экран числа больше 10.")
    void task_number_35 (){
        Stream<Integer> one = Stream.iterate(0,i -> ++i).limit(11);
        Stream<Integer> two = Stream.iterate(10,i -> ++i).limit(11);

        Stream
                .concat(one,two)
                .filter(x-> x>10)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName(" 36) Создать стрим чисел от 0 до 100. Умножить их на 2 и вывести на экран результат, ограничиться первыми 10 результатами.")
    void task_number_36 (){
        Stream
                .iterate(0,i -> ++i)
                .limit(101)
                .map(x -> x * 2)
                .limit(10)
                .forEach(System.out::println);

    }

    @Test
    @DisplayName(" 37) Создать стрим, который выводит числа от 1 до 10. Найти среднее арифметическое этих чисел и вывести его на экран.")
    void task_number_37 () {
        OptionalDouble average = Stream
                .iterate(1, i -> ++i)
                .limit(10)
                .mapToInt(x -> x)
                .average();

        average.ifPresent(System.out::println);
    }

    @Test
    @DisplayName(" 38) Создать три стрима из массивов чисел от 1 до 10, от 10 до 20 и от 20 до 30 соответственно. Объединить их в один стрим и вывести числа, которые кратны 5.")
    void task_number_38 () {
        Stream<Integer> one = Stream.iterate(1,i -> ++i).limit(10);
        Stream<Integer> two = Stream.iterate(10,i -> ++i).limit(11);
        Stream<Integer> three = Stream.iterate(20,i -> ++i).limit(11);

        one = Stream.concat(one,two);
        Stream
                .concat(one,three)
                .filter(x -> x % 5==0)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName(" 39) Создать стрим четных чисел от 2 до 40 и вывести на экран количество элементов в этом стриме.")
    void task_number_39 () {

      long count = Stream
              .iterate(2, i -> ++i)
              .limit(39)
              .count();

      System.out.println(count);

    }
    @Test
    @DisplayName(" 40) Разделить элементы Stream на две группы: четные и нечетные, вывести результаты.")
    void task_number_40 () {

      Stream
              .iterate(1, i -> ++i)
              .limit(100)
              .collect(Collectors.partitioningBy(x-> x % 2 == 0))
              .values()
              .forEach(System.out::println);

    }

}
