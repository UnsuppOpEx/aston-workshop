package aston.task1.collections;

public interface CustomList<E> {

    void add(E element);

    E get(int index);

    void remove(int index);

    void addAll(CustomList<? extends E> e);

    int size();
}
