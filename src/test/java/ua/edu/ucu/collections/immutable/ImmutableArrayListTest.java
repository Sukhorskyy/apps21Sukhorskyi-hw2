package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ImmutableArrayListTest {
    Object[] arr = {8, 5, 12, 3};
    ImmutableArrayList list = new ImmutableArrayList(arr);
    ImmutableList testList;

    @Test
    public void testAdd1() {
        testList = list.add(29);
        assertEquals(29, testList.get(4));
    }

    @Test
    public void testAdd2() {
        testList = list.add(1, 29);
        assertEquals(29, testList.get(1));
    }

    @Test
    public void testAddAll1() {
        Object arr[] = {38, 25};
        testList = list.addAll(arr);
        assertEquals("[8, 5, 12, 3, 38, 25]", Arrays.toString(testList.toArray()));
    }

    @Test
    public void testAddAll2() {
        Object arr[] = {31, 24};
        testList = list.addAll(2, arr);
        assertEquals("[8, 5, 31, 24, 12, 3]", Arrays.toString(testList.toArray()));
    }

    @Test
    public void testRemove() {
        testList = list.remove(2);
        assertEquals("[8, 5, 3]", Arrays.toString(testList.toArray()));
    }

    @Test
    public void testSet() {
        testList = list.set(1, 0);
        assertEquals(0, testList.get(1));
        assertEquals(5, list.get(1));
    }

    @Test
    public void testIndexOf() {
        assertEquals(1, list.indexOf(5));
    }

    @Test
    public void testSize() {
        assertEquals(4, list.size());
    }

    @Test
    public void testClear() {
        testList = list.clear();
        assertEquals(0, testList.size());
    }

    @Test
    public void testIsEmpty() {
        assertEquals(false, list.isEmpty());
    }
}