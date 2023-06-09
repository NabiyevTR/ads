package ru.ntr.library;

public interface LinkedList<E> extends Iterable<E>{

    void insertFirst(E value);

    E removeFirst();

    E getFirst();

    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display();


    class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
