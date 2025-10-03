package org.example.homework1.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomArrayListTest {

    @Test
    void add() {
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        assertEquals(3, customArrayList.size());
    }

    @Test
    void get() {
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        Integer result = customArrayList.get(2);
        assertEquals(3, result);
    }

    @Test
    void remove() {
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        assertEquals(3, customArrayList.size());
        customArrayList.remove(2);
        assertEquals(2, customArrayList.size());
    }

    @Test
    void addAll() {
        CustomArrayList<Integer> firstCustomArrayList = new CustomArrayList<>();
        firstCustomArrayList.add(1);
        firstCustomArrayList.add(2);
        firstCustomArrayList.add(3);
        CustomArrayList<Integer> secondCustomArrayList = new CustomArrayList<>();
        secondCustomArrayList.add(4);
        secondCustomArrayList.add(5);
        secondCustomArrayList.add(6);
        firstCustomArrayList.addAll(secondCustomArrayList);
        assertEquals(6, firstCustomArrayList.size());
    }

    @Test
    void size() {
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        assertEquals(3, customArrayList.size());
    }
}
