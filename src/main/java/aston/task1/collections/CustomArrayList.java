package aston.task1.collections;

import java.util.Arrays;

public class CustomArrayList<E> implements CustomList<E> {
    private final int CAPACITY = 10;
    private Object[] elements;
    private int size;


    public CustomArrayList() {
        this.elements = new Object[CAPACITY];
        this.size = 0;
    }

    @Override
    public void add(E e) {
        checkLengthAndUpdateCapacity();
        elements[size++] = e;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        int countShift = size - index - 1;
        if (countShift > 0) {
            System.arraycopy(elements, index + 1, elements, index, countShift);
        }
        elements[--size] = null;
    }

    @Override
    public void addAll(CustomList<? extends E> c) {
        for (int i = 0; i < c.size(); i++) {
            add(c.get(i));
        }
    }

    @Override
    public int size() {
        return size;
    }

    private void checkLengthAndUpdateCapacity() {
        if (size >= elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
