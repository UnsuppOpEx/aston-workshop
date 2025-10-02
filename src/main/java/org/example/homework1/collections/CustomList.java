package org.example.homework1.collections;

public interface CustomList<T> {

    void add(T element);

    T get(int index);

    void remove(int index);

    void addAll(CustomList<? extends T> e);

    int size();
}
