package ru.aston.popov_am.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    ArrayList<Integer> arrayList = new ArrayList<>();
    @BeforeEach
    public void beforeEach() {
        arrayList.addAll(Arrays.asList(15, 4, 34, 1, 53));
    }

    @Test
    void testSort(){
        ArrayList<Integer> arrayList1 = new ArrayList<>(List.of(1,4,15,34,53));
        Collections.sort(arrayList);
        Assertions.assertEquals(arrayList1,arrayList);
    }

    @Test
    void testBinarySearchIfElementFindReturnIndex(){
        Collections.sort(arrayList);
        Assertions.assertEquals(3,Collections.binarySearch(arrayList,34));
    }
    @Test
    void testCopy(){
        ArrayList<Integer> copy = new ArrayList<>(List.of(0,0,0,0,0));
        Collections.copy(copy,arrayList);
        Assertions.assertEquals(arrayList,copy);
    }

    @Test
    void testFill(){
        Collections.fill(arrayList,0);
        ArrayList<Integer> arrayList1 = new ArrayList<>(List.of(0,0,0,0,0));
        Assertions.assertEquals(arrayList,arrayList1);
    }

    @Test
    void testMax(){
        Assertions.assertEquals(53,Collections.max(arrayList));
    }

    @Test
    void testMin(){
        Assertions.assertEquals(1,Collections.min(arrayList));
    }

    @Test
    void testReverse(){
        ArrayList<Integer> arrayList1  = new ArrayList<>(List.of(1,2,3,4));
        Collections.reverse(arrayList1);
        Assertions.assertEquals(4,arrayList1.get(0));
    }
}
