package org.example;

import org.example.exeptions.ArraysIsFullExeption;
import org.example.exeptions.InvalidIndexExeption;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    StringListImpl stringList1 = new StringListImpl(1);
    StringListImpl stringList2 = new StringListImpl();
    String element = "Hello";

    @Test
    void shouldAddedNewElementAndThrowExceptions() {
        String a = stringList1.add(element);
        assertEquals(element, a);
        assertThrows(ArraysIsFullExeption.class, () -> stringList1.add(element));
        assertThrows(NullPointerException.class, () -> stringList2.add(null));
    }

    @Test
    void shouldAddedNewElementOnPositionIndexAndThrowExceptions() {
        String a = stringList1.add(0, element);
        assertEquals(stringList1.get(0), a);
        assertThrows(ArraysIsFullExeption.class, () -> stringList1.add(1, element));
        assertThrows(NullPointerException.class, () -> stringList2.add(null));
        assertThrows(InvalidIndexExeption.class, () -> stringList2.add(15, element));
    }

    @Test
    void shouldSetNewElementOnPositionIndexAndThrowExceptions() {
        stringList1.add(element);
        String b = "hi";
        assertEquals(b, stringList1.set(0, b));
        assertThrows(InvalidIndexExeption.class, () -> stringList1.set(15, element));
        assertThrows(NullPointerException.class, () -> stringList1.set(0, null));
    }

    @Test
    void shouldRemoveElementAndThrowExceptions() {
        stringList2.add(element);
        stringList2.remove(element);
        assertFalse(stringList2.contains(element));
        assertThrows(NullPointerException.class, () -> stringList1.remove(null));
    }

    @Test
    void shouldRemoveOnPositionIndexElementAndThrowExceptions() {
        stringList2.add(0, element);
        stringList2.remove(0);
        assertFalse(stringList2.contains(element));
        assertThrows(InvalidIndexExeption.class, () -> stringList2.remove(15));
    }

    @Test
    void shouldContainsElementAndThrowExceptions() {
        stringList2.add(element);
        assertTrue(stringList2.contains(element));
        assertFalse(stringList2.contains("Hi"));
    }

    @Test
    void shouldIndexOfFindElement() {
        stringList2.add(element);
        String a = "Hi";
        stringList2.add(a);
        assertEquals(0, stringList2.indexOf(element));
        assertEquals(1, stringList2.indexOf(a));
    }

    @Test
    void shouldLastIndexOfFindElement() {
        stringList2.add(element);
        String a = "Hi";
        stringList2.add(a);
        assertEquals(0, stringList2.lastIndexOf(element));
        assertEquals(1, stringList2.lastIndexOf(a));
    }

    @Test
    void shouldGetElement() {
        stringList2.add(0, element);
        assertEquals(element, stringList2.get(0));
    }

    @Test
    void shouldEqualsStringLists() {
        stringList2.add(element);
        stringList1.add(element);
        assertTrue(stringList1.equals(stringList2));
    }

    @Test
    void shouldSizeStringList() {
        stringList2.add(element);
        assertEquals(1, stringList2.size());
    }

    @Test
    void shouldIsEmptyStringList() {
        stringList2.add(element);
        assertFalse(stringList2.isEmpty());
    }

    @Test
    void shouldClearStringList() {
        stringList2.add(element);
        stringList2.clear();
        assertTrue(stringList2.isEmpty());
        assertFalse(stringList2.contains(element));
    }

    @Test
    void toArray() {
        stringList2.add(element);
        String[] strings = stringList2.toArray();
        assertArrayEquals(new String[]{element}, strings);
    }
}