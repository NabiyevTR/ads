package ru.ntr.library;

public interface IQueue<E> {

    boolean insert(E value);

    E remove();

    E peekHead();

    int size();

    void display();

    boolean isEmpty();

    boolean isFull();

}
