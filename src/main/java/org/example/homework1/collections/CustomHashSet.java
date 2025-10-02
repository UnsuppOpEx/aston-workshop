package org.example.homework1.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class CustomHashSet<T> implements HasSetAble {
    private static final int CAPACITY = 16;
    private final ArrayList<LinkedList<T>> table;
    private int size;

    public CustomHashSet() {
        table = new ArrayList<>(CAPACITY);
        for (int i = 0; i < CAPACITY; i++) {
            table.add(null);
        }
    }

    @Override
    public boolean add(Object e) {
        int idx = indexFor(hash(e));
        if (table.get(idx) == null) {
            table.set(idx, new LinkedList<>());
        }
        for (T element : table.get(idx)) {
            if (Objects.equals(element, e)) {
                return false;
            }
        }
        table.get(idx).add((T) e);
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int idx = indexFor(hash(o));
        LinkedList<T> bucket = table.get(idx);
        if (bucket == null) return false;
        boolean removed = bucket.remove(o);
        if (removed) size--;
        return removed;
    }

    public int size() {
        return size;
    }


    private int hash(Object o) {
        return (o == null) ? 0 : o.hashCode();
    }


    private int indexFor(int hash) {
        return Math.floorMod(hash, table.size());
    }
}
