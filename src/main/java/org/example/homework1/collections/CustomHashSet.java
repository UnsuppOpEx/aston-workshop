package org.example.homework1.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class CustomHashSet<E> implements CustomSet<E> {
    private static final int CAPACITY = 16;
    private final ArrayList<List<E>> table;
    private int size;

    public CustomHashSet() {
        table = new ArrayList<>(CAPACITY);
        for (int i = 0; i < CAPACITY; i++) {
            table.add(null);
        }
    }

    @Override
    public boolean add(E e) {
        int idx = indexFor(hash(e));
        if (table.get(idx) == null) {
            table.set(idx, new LinkedList<>());
        }
        for (E element : table.get(idx)) {
            if (Objects.equals(element, e)) {
                return false;
            }
        }
        table.get(idx).add(e);
        size++;
        return true;
    }

    @Override
    public void remove(E o) {
        int idx = indexFor(hash(o));
        List<E> bucket = table.get(idx);
        if (bucket == null) return;
        boolean removed = bucket.remove(o);
        if (removed) size--;
    }

    public int size() {
        return size;
    }

    private int hash(E o) {
        return (o == null) ? 0 : o.hashCode();
    }

    private int indexFor(int hash) {
        return Math.floorMod(hash, table.size());
    }
}
