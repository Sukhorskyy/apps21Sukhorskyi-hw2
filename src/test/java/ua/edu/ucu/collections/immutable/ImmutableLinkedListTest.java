package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class ImmutableLinkedListTest {
    Object[] arr = {8, 5, 12, 3};
    ImmutableLinkedList list = new ImmutableLinkedList(arr);
    ImmutableList testList;

    @Test
    public void testAdd() {
        testList = list.add(29);
        assertEquals("[8, 5, 12, 3, 29]", Arrays.toString(testList.toArray()));
        assertEquals("[8, 5, 12, 3]", Arrays.toString(list.toArray()));
    }

    @Test
    public void testAddAll() {
        Object arr[] = {34, 67};
        testList = list.addAll(arr);
        assertEquals("[8, 5, 12, 3, 34, 67]", Arrays.toString(testList.toArray()));
    }

    @Test
    public void testRemove() {
        testList = list.remove(1);
        assertEquals("[8, 12, 3]", Arrays.toString(testList.toArray()));
    }

    @Test
    public void testIndexOf() {
        assertEquals(0, list.indexOf(8));
    }

    @Test
    public void testSize() {
        assertEquals(4, list.size());
    }

    @Test
    public void testClear() {
        testList = list.clear();
        assertEquals("[]", Arrays.toString(testList.toArray()));
    }

    @Test
    public void testIsEmpty() {
        assertEquals(false, list.isEmpty());
    }

    @Test
    public void testAddFirst() {
        testList = list.addFirst(0);
        assertEquals("[0, 8, 5, 12, 3]", Arrays.toString(testList.toArray()));
    }

    @Test
    public void testAddLast() {
        testList = list.addLast(0);
        assertEquals("[8, 5, 12, 3, 0]", Arrays.toString(testList.toArray()));
    }

    @Test
    public void testGetHead() {
        Node head = list.getHead();
        assertEquals(8, head.getValue());
    }

    @Test
    public void testGetTail() {
        Node tail = list.getTail();
        assertEquals(3, tail.getValue());
    }

    @Test
    public void testGetFirst() {
        int first = (int) list.getFirst();
        assertEquals(8, first);
    }

    @Test
    public void testGetLast() {
        int last = (int) list.getLast();
        assertEquals(3, last);
    }

    @Test
    public void testRemoveFirst() {
        testList = list.removeFirst();
        assertEquals("[5, 12, 3]", Arrays.toString(testList.toArray()));
    }

    @Test
    public void testRemoveLast() {
        testList = list.removeLast();
        assertEquals("[8, 5, 12]", Arrays.toString(testList.toArray()));
    }
}