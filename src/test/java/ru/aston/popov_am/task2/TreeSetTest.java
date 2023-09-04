package ru.aston.popov_am.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {

     // Создает новый, пустой древовидный набор, сортированный согласно естественному упорядочиванию его элементов.
     TreeSet<String> defaultConstructor = new TreeSet<>();

     // Создает новый, пустой древовидный набор, сортированный с помощью Comparable или Comparator
     TreeSet<String> constructorWithComparableOrComparator = new TreeSet<>(Comparator.comparing(String::length));

     // TreeSet(Collection<? extends E> col): создает дерево, в которое добавляет все элементы коллекции col.

     // TreeSet(SortedSet <E> set): создает дерево, в которое добавляет все элементы сортированного набора set


     @BeforeEach
     public void beforeEach() {
          defaultConstructor.add("Anna");
          defaultConstructor.add("Bill");
          defaultConstructor.add("Andrey");
          defaultConstructor.add("John");
     }

     @Test
     void testAddReturnTrue(){
          Assertions.assertTrue(defaultConstructor.add("Kate"));
     }

     @Test
     void testAddReturnFalse(){
          Assertions.assertFalse(defaultConstructor.add("Anna"));
     }

     @Test
     void testContainsReturnTrueIfTheElementIsFound(){
          Assertions.assertTrue(defaultConstructor.contains("Anna"));
     }

     @Test
     void testIsEmptyReturnTrueIfCollectionIsEmpty(){
          Assertions.assertTrue(constructorWithComparableOrComparator.isEmpty());
     }

     @Test
     void testRemoveReturnTrueIfElementHasBeenRemoved(){
          Assertions.assertTrue(defaultConstructor.remove("Andrey"));
     }
     @Test
     void testSize(){
          Assertions.assertEquals(4,defaultConstructor.size());
     }
}
