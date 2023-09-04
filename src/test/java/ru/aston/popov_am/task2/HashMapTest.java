package ru.aston.popov_am.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class HashMapTest {
    Map<Integer,String> defaultConstructor = new HashMap<>();
    Map<Integer,String> ConstructorWithCapacity = new HashMap<>(100);
    Map<Integer,String> ConstructorWithCapacityAndLoadFactor = new HashMap<>(100,0.75f);

    @BeforeEach
    public void beforeEach() {
        defaultConstructor.put(1,"one");
        defaultConstructor.put(2,"two");
        defaultConstructor.put(3,"three");
        defaultConstructor.put(4,"four");
        defaultConstructor.put(5,"five");
    }


    @Test
    void constructorTestingWhichTakesAnotherCollection() {
      HashMap<Integer,String> hashMap = new HashMap<>();
      hashMap.put(1,"one");
      hashMap.put(2,"two");
      HashMap<Integer,String> hashMap1 = new HashMap<>(hashMap);
      Assertions.assertEquals(hashMap,hashMap1);
    }

    @Test
    void testGet(){
      String get = defaultConstructor.get(3);
      Assertions.assertEquals("three",get);
    }

    @Test
    void testContainsKeyTrue(){
       Assertions.assertTrue(defaultConstructor.containsKey(4));
    }
    @Test
    void testContainsKeyFalse(){
        Assertions.assertFalse(defaultConstructor.containsKey(777));
    }

    @Test
    void testSize(){
        Assertions.assertEquals(5,defaultConstructor.size());
    }

    @Test
    void testPut(){
       Assertions.assertNull(defaultConstructor.put(6,"six"));
    }

    @Test
    void testPutIfAbsent(){
        defaultConstructor.putIfAbsent(7,"seven");
        Assertions.assertEquals("seven",defaultConstructor.get(7));
    }

    @Test
    void testContainsValueFalse(){
        Assertions.assertFalse(defaultConstructor.containsValue("ten"));
    }
    @Test
    void testContainsValueTrue(){
        Assertions.assertTrue(defaultConstructor.containsValue("three"));
    }

    @Test
    void testGetOrDefaultReturnDefaultValue(){
    Assertions.assertEquals("Not key",defaultConstructor.getOrDefault(99,"Not key"));
    }

    @Test
    void testGetOrDefaultReturnValue(){
        Assertions.assertEquals("five",defaultConstructor.getOrDefault(5,"Not key"));
    }

    @Test
    void testIsEmpty(){
        HashMap<Integer,Integer> isEmpty = new HashMap<>();
        Assertions.assertTrue(isEmpty.isEmpty());
    }

    @Test
    void testKeySet(){
        Set<Integer> number = new HashSet<>(List.of(1,2,3,4,5));
        Assertions.assertEquals(number,defaultConstructor.keySet());
    }

    @Test
    void testRemoveByKeyAndReturnValue(){
        Assertions.assertEquals("five",defaultConstructor.remove(5));
    }

    @Test
    void testRemoveByKeyAndByValueReturnTrue(){
        Assertions.assertTrue(defaultConstructor.remove(5,"five"));
    }

    @Test
    void testRemoveByKeyAndByValueReturnFalse(){
        Assertions.assertFalse(defaultConstructor.remove(5,"six"));
    }
}
