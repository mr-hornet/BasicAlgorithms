package org.example;

import org.example.exeptions.ArraysIsFullExeption;
import org.example.exeptions.InvalidIndexExeption;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {

    IntegerListImpl IntegerList1 = new IntegerListImpl(1);
    IntegerListImpl IntegerList2 = new IntegerListImpl();
    Integer element = 12;

    @Test
    void shouldAddedNewElementAndThrowExceptions() {
        Integer a = IntegerList1.add(element);
        assertEquals(element, a);
        assertThrows(ArraysIsFullExeption.class, () -> IntegerList1.add(element));
        assertThrows(NullPointerException.class, () -> IntegerList2.add(null));
    }

    @Test
    void shouldAddedNewElementOnPositionIndexAndThrowExceptions() {
        Integer a = IntegerList1.add(0, element);
        assertEquals(IntegerList1.get(0), a);
        assertThrows(ArraysIsFullExeption.class, () -> IntegerList1.add(1, element));
        assertThrows(NullPointerException.class, () -> IntegerList2.add(null));
        assertThrows(InvalidIndexExeption.class, () -> IntegerList2.add(15, element));
    }

    @Test
    void shouldSetNewElementOnPositionIndexAndThrowExceptions() {
        IntegerList1.add(element);
        Integer b = 15;
        assertEquals(b, IntegerList1.set(0, b));
        assertThrows(InvalidIndexExeption.class, () -> IntegerList1.set(15, element));
        assertThrows(NullPointerException.class, () -> IntegerList1.set(0, null));
    }

    @Test
    void shouldRemoveElementAndThrowExceptions() {
        IntegerList2.add(element);
        IntegerList2.remove(element);
        assertFalse(IntegerList2.contains(element));
        assertThrows(NullPointerException.class, () -> IntegerList1.remove(null));
    }

    @Test
    void shouldRemoveOnPositionIndexElementAndThrowExceptions() {
        IntegerList2.add(0, element);
        IntegerList2.remove(0);
        assertFalse(IntegerList2.contains(element));
        assertThrows(InvalidIndexExeption.class, () -> IntegerList2.remove(15));
    }

    @Test
    void shouldContainsElementAndThrowExceptions() {
        IntegerList2.add(element);
        assertTrue(IntegerList2.contains(element));
        assertFalse(IntegerList2.contains(15));
    }

    @Test
    void shouldIndexOfFindElement() {
        IntegerList2.add(element);
        Integer a = 15;
        IntegerList2.add(a);
        assertEquals(0, IntegerList2.indexOf(element));
        assertEquals(1, IntegerList2.indexOf(a));
    }

    @Test
    void shouldLastIndexOfFindElement() {
        IntegerList2.add(element);
        Integer a = 15;
        IntegerList2.add(a);
        assertEquals(0, IntegerList2.lastIndexOf(element));
        assertEquals(1, IntegerList2.lastIndexOf(a));
    }

    @Test
    void shouldGetElement() {
        IntegerList2.add(0, element);
        assertEquals(element, IntegerList2.get(0));
    }

    @Test
    void shouldEqualsIntegerLists() {
        IntegerList2.add(element);
        IntegerList1.add(element);
        assertTrue(IntegerList1.equals(IntegerList2));
    }

    @Test
    void shouldSizeIntegerList() {
        IntegerList2.add(element);
        assertEquals(1, IntegerList2.size());
    }

    @Test
    void shouldIsEmptyIntegerList() {
        IntegerList2.add(element);
        assertFalse(IntegerList2.isEmpty());
    }

    @Test
    void shouldClearIntegerList() {
        IntegerList2.add(element);
        IntegerList2.clear();
        assertTrue(IntegerList2.isEmpty());
        assertFalse(IntegerList2.contains(element));
    }

    @Test
    void toArray() {
        IntegerList2.add(element);
        Integer[] Integers = IntegerList2.toArray();
        assertArrayEquals(new Integer[]{element}, Integers);
    }

}