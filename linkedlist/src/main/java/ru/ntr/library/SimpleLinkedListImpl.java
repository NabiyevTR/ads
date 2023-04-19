package ru.ntr.library;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected int size;
    protected Node<E> firstElement;


    @Override
    public void insertFirst(E value) {
        firstElement = new Node<>(value, firstElement);
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
        removedElement.next = null;
        removedElement.item = null;
        size--;
        return data;
    }

    @Override
    public boolean remove(E value) {

        Node<E> current = firstElement;
        Node<E> previous = null;

        if (isEmpty()) {
            return false;
        }

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == firstElement) {
            firstElement = firstElement.next;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        current.item = null;

        size--;
        return true;
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
        return firstElement == null;
    }

    @Override
    public E getFirst() {
        return firstElement.item;
    }

   /* @Override
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        for (E e : this) {
            action.accept(e);
        }
    }*/

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {

            private Node<E> currentElement = firstElement;
            private boolean first =false;

            @Override
            public boolean hasNext() {
                if (isEmpty()) {
                    return false;
                } else {
                    return currentElement.next != null;
                }

            }

            @Override
            public E next() {
                if (!first) {
                    first = true;
                } else {
                    currentElement = currentElement.next;
                }
                return currentElement.item;
            }
        };
        return iterator;
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
