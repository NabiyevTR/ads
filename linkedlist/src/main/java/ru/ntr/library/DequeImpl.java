package ru.ntr.library;

public class DequeImpl<E> extends TwoSideLinkedListImpl<E> implements Deque<E> {
    @Override
    public void addFirst(E obj) {
        insertFirst(obj);
    }

    @Override
    public void addLast(E obj) {
        insertLast(obj);
    }

    @Override
    public boolean offerFirst(E obj) {
        insertFirst(obj);
        return true;
    }

    @Override
    public boolean offerLast(E obj) {
        insertLast(obj);
        return true;
    }

    @Override
    public E peekFirst() {
        return getFirst();
    }

    @Override
    public E peekLast() {
        return getLast();
    }

    @Override
    public E pollFirst() {
        return removeFirst();
    }

    @Override
    public E pollLast() {
        return removeLast();
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public void push(E element) {
        insertFirst(element);
    }

    @Override
    public boolean removeFirstOccurrence(E obj) {
        return remove(obj);
    }

    @Override
    public boolean removeLastOccurrence(E obj) {
        return removeLast(obj);
    }
}
