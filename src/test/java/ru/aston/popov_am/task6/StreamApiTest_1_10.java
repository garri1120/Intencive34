package ru.aston.popov_am.task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Stream;

public class StreamApiTest_1_10 {
    @Test
    @DisplayName(" 1) Вывести все четные числа в диапазоне от 1 до 100 ")
    void task_number_1(){
        Stream
                .iterate(1, i -> ++i)
                .limit(100)
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName(" 2) Умножить каждое число в массиве [1, 2, 3, 4, 5] на 2 ")
    void task_number_2(){

       int [] numbers = {1,2,3,4,5};

       Arrays.stream(numbers)
               .map(x -> x * 2)
               .forEach(System.out::println);
    }

    @Test
    @DisplayName(" 3) Посчитать сумму чисел в массиве [1, 2, 3, 4, 5], используя reduce() ")
    void task_number_3(){

        int [] numbers = {1,2,3,4,5};

        OptionalInt sumOfNumbers = Arrays
                .stream(numbers)
                .reduce(Integer::sum);

        Assertions.assertEquals(15,sumOfNumbers.getAsInt());
    }
    @Test
    @DisplayName(" 4) Вывести числа в диапазоне от 1 до 50 с шагом 2 ")
    void task_number_4(){
        Stream
                .iterate(1, i -> ++i)
                .limit(50)
                .filter(x -> x % 2 != 0)
                .forEach(System.out::println);
    }
    @Test
    @DisplayName(" 5) Найти первый четный элемент в списке [1, 2, 3, 4, 5]")
    void task_number_5(){

        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4,5));

        Optional<Integer> number = numbers
                .stream()
                .filter(x -> x % 2 == 0)
                .findFirst();

        number.ifPresent(System.out::println);
    }

    @Test
    @DisplayName(" 6) Отсортировать элементы массива [1, 3, 5, 7, 9] по возрастанию")
    void task_number_6(){

        int [] numbers = {7,1,9,5,3};

        Arrays.stream(numbers)
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    @DisplayName(" 7) Вывести первые 10 чисел в списке [0, 1, 2, … 99]")
    void task_number_7(){

       List<Integer> integerList = Stream.iterate(0, i -> ++i).limit(100).toList();

       integerList
               .stream()
               .limit(10)
               .forEach(System.out::println);

    }

    @Test
    @DisplayName(" 8) Пропустить первые 10 элементов списка [0, 1, 2,.., 99] и начать выводить с 11-го элемента, выводя каждый 10-й элемент")
    void task_number_8(){

        List<Integer> integerList = Stream.iterate(0, i -> ++i).limit(100).toList();

        integerList
                .stream()
                .skip(10)
                .filter(x -> x % 10 == 0)
                .forEach(System.out::println);

    }

    @Test
    @DisplayName(" 9) Выведите на экран все числа в диапазоне от 1 до 100, которые делятся на 3")
    void task_number_9(){

        List<Integer> integerList = Stream.iterate(1, i -> ++i).limit(100).toList();

        integerList
                .stream()
                .filter(x -> x % 3 == 0)
                .forEach(System.out::println);

    }

    @Test
    @DisplayName(" 10) Выведите все нечетные числа в заданном массиве.")
    void task_number_10(){

        int [] numbers = {2,33,5,76,99,102,431,26,27};

        Arrays
                .stream(numbers)
                .filter(x -> x % 2 != 0)
                .forEach(System.out::println);
    }
}
