package ru.ntr.library;

import java.util.LinkedList;

public class StackImpl<E> extends SimpleLinkedListImpl<E> implements Stack<E> {
    @Override
    public void push(E value) {
        insertFirst(value);
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public E peek() {
        return getFirst();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
