package ru.aston.popov_am.task2;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {
    ArrayList<Integer> arrayList = new ArrayList<>();

    // ArrayList(Collection <? extends E> col): создает список, в который добавляются все элементы коллекции col.
    // ArrayList (int capacity): создает список, который имеет начальную емкость capacity

    @BeforeEach
    public void beforeEach() {
        arrayList.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }


    @Test
    void constructorTestingWhichTakesAnotherCollection() {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> arrayList2 = new ArrayList<>(arrayList1);

        Assertions.assertEquals(arrayList1,arrayList2);

    }
    @Test
    void testGet(){
        int number = 5;
        int arrayListNumber = arrayList.get(4);
        Assertions.assertEquals(number,arrayListNumber);
    }

    @Test
    void testSize(){
        int size = 10;
        Assertions.assertEquals(size, arrayList.size());
    }

    @Test
    void testContains(){
       Assertions.assertTrue(arrayList.contains(4));
    }

    @Test
    void testSet(){
        arrayList.set(4,999);
        Assertions.assertEquals(999,arrayList.get(4));
    }

    @Test
    void testAdd1(){
        arrayList.add(555);
        Assertions.assertEquals(11,arrayList.size());
    }
    @Test
    void testAdd2(){
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        Assertions.assertEquals(1,arrayList1.get(0));
    }

    @Test
    void testRemoteByIndex(){
        ArrayList<Integer> arrayList1 = new ArrayList<>(List.of(1));
        arrayList1.remove(0);
        Assertions.assertTrue(arrayList1.isEmpty());
    }

    @Test
    void testRemoteByObject(){
        ArrayList<Integer> arrayList1 = new ArrayList<>(List.of(777));
        Integer delete = 777;
        arrayList1.remove(delete);
        Assertions.assertTrue(arrayList1.isEmpty());
    }

    @Test
    void testClear(){
        ArrayList<Integer> arrayList1 = new ArrayList<>(List.of(1,2,3,4,5));
        arrayList1.clear();
        Assertions.assertTrue(arrayList1.isEmpty());
    }
}
