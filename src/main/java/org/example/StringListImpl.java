package org.example;

import org.example.exeptions.ArraysIsFullExeption;
import org.example.exeptions.InvalidIndexExeption;
import org.example.exeptions.NotElementExeption;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private final String[] arrayString;
    private int size;

    public StringListImpl() {
        arrayString = new String[10];
    }

    public StringListImpl(int size) {
        arrayString = new String[size];
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullPointerException();
        }
    }

    private void validateSize() {
        if (size == arrayString.length) {
            throw new ArraysIsFullExeption();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexExeption();
        }
    }

    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        arrayString[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            arrayString[size++] = item;
            return item;
        }

        System.arraycopy(arrayString, index, arrayString, index + 1, size - index);
        arrayString[index] = item;
        size++;

        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        arrayString[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public String remove(int index) {
        validateIndex(index);

        String item = arrayString[index];

        if (index != size) {
            System.arraycopy(arrayString, index + 1, arrayString, index, size - index);
        }

        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (arrayString[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (arrayString[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return arrayString[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(arrayString, size);
    }
}
