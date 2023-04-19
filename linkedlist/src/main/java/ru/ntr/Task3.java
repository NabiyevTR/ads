package ru.ntr;

import ru.ntr.library.LinkedList;
import ru.ntr.library.SimpleLinkedListImpl;

import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class Task3 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        for (int i = 0; i < 10; i++) {
            linkedList.insertFirst(ThreadLocalRandom.current().nextInt(0, 100));
        }

        for (Integer number : linkedList) {
            System.out.print(number + " ");
        }

        System.out.println();

        for (Integer integer : linkedList) {
            System.out.print(integer + " ");
        }

        System.out.println();

        linkedList.forEach(e -> System.out.print(e + " "));

        System.out.println();

        class Item {
            int number;
            boolean isPrintable;

            public Item(int number, boolean isPrintable) {
                this.number = number;
                this.isPrintable = isPrintable;
            }

            @Override
            public String toString() {
                return String.valueOf(number);
            }
        }

        LinkedList<Item> items = new SimpleLinkedListImpl<>();
        items.insertFirst(new Item(1, true));
        items.insertFirst(new Item(2, true));
        items.insertFirst(new Item(3, false));
        items.insertFirst(new Item(4, true));
        items.insertFirst(new Item(5, true));

        items.forEach(e -> {
            if (e.isPrintable) {
                System.out.print(e.number + " ");
            }
        });

    }
}
