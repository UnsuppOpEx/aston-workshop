package org.example.homework1.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomHashSetTest {

    @Test
    void add() {
        CustomHashSet<String> set = new CustomHashSet<>();
        set.add("one");
        set.add("two");
        assertEquals(2, set.size());
        set.add("one");
        assertEquals(2, set.size());

    }

    @Test
    void remove() {
        CustomHashSet<String> set = new CustomHashSet<>();
        set.add("one");
        set.add("two");
        assertEquals(2, set.size());
        set.remove("one");
        assertEquals(1, set.size());
    }

    @Test
    void size() {
        CustomHashSet<Long> set = new CustomHashSet<>();
        set.add("one");
        set.add("two");
        assertEquals(2, set.size());
    }
}
