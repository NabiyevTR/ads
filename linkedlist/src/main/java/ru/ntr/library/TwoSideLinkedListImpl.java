package ru.ntr.library;

import java.util.Iterator;
import java.util.function.Consumer;

public class TwoSideLinkedListImpl<E> implements TwoSideLinkedList<E> {

    protected int size;
    private Node<E> firstElement;
    private Node<E> lastElement;

    @Override
    public void insertFirst(E value) {
        Node<E> entry = new Node<>(value, null, firstElement);
        if (isEmpty()) {
            firstElement = entry;
        } else {
            firstElement.previous = entry;
            firstElement = entry;
        }

        size++;

        if (size == 1) {
            lastElement = firstElement;
        }


    }

    @Override
    public void insertLast(E value) {
        Node<E> entry = new Node<>(value, lastElement, null);
        if (isEmpty()) {
            firstElement = entry;
        } else {
            lastElement.next = entry;
        }
        lastElement = entry;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedElement = firstElement;
        E data = removedElement.item;
        firstElement = firstElement.next;
        removedElement.previous = null;
        removedElement.next = null;
        removedElement.item = null;
        size--;
        if (isEmpty()) {
            lastElement = null;
        }
        return data;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedElement = lastElement;
        E data = removedElement.item;
        lastElement = lastElement.previous;
        lastElement.next = null;
        removedElement.previous = null;
        removedElement.next = null;
        removedElement.item = null;
        size--;
        if (isEmpty()) {
            firstElement = null;
        }
        return data;
    }


    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> next = current.next;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
            next = current.next;
        }

        if (current == null) {
            return false;
        }

        if (size() == 1) {
            return removeFirst() != null;
        }

        if (current == firstElement) {
            firstElement = next;
            next.previous = null;
        } else if (current == lastElement) {
            lastElement = previous;
            previous.next = null;
        } else {
            previous.next = current.next;
            next.previous = current.previous;
        }

        current.previous = null;
        current.next = null;
        current.item = null;

        size--;
        return true;
    }

    @Override
    public boolean removeLast(E value) {
        Node<E> current = lastElement;
        Node<E> previous = lastElement.previous;
        Node<E> next = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }

            current = current.previous;
            previous = current.previous;
            next = current.next;
        }

        if (current == null) {
            return false;
        }

        if (size() == 1) {
            return removeFirst() != null;
        }

        if (current == firstElement) {
            firstElement = next;
            next.previous = null;
        } else if (current == lastElement) {
            lastElement = previous;
            previous.next = null;
        } else {
            previous.next = current.next;
            next.previous = current.previous;
        }

        current.previous = null;
        current.next = null;
        current.item = null;

        size--;
        return true;
    }

    @Override
    public E getLast() {
        return lastElement.item;
    }

    @Override
    public E getFirst() {
        return firstElement.item;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        //todo
    }

    @Override
    public Iterator<E> iterator() {
        //todo
        return null;
    }

    @Override
    public String toString() {
        Node<E> current = firstElement;
        StringBuilder sb = new StringBuilder().append("[");
        while (current != null) {
            sb.append(current.item);
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }

    @Override
    public void display() {
        System.out.println("------------------------------------");
        System.out.println(this.toString());
        System.out.println("------------------------------------");
    }
}
