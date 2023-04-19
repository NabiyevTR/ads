package ru.ntr;

import ru.ntr.library.*;

public class Task1 {
    public static void main(String[] args) {

        //Simple linked list
        LinkedList<Integer> simpleLinkedList = new SimpleLinkedListImpl<>();
        simpleLinkedList.insertFirst(5);
        simpleLinkedList.insertFirst(4);
        simpleLinkedList.insertFirst(3);
        simpleLinkedList.insertFirst(2);
        simpleLinkedList.insertFirst(1);
        simpleLinkedList.display(); //[1, 2, 3, 4, 5]
        System.out.println(simpleLinkedList.getFirst()); //1
        System.out.println(simpleLinkedList.contains(3)); //true
        simpleLinkedList.remove(2);
        System.out.println(simpleLinkedList.contains(2)); //false
        simpleLinkedList.removeFirst();
        simpleLinkedList.display(); //[3, 4, 5]

        //Linked list
        TwoSideLinkedList<Integer> twoSideLinkedList = new TwoSideLinkedListImpl<>();
        twoSideLinkedList.insertFirst(3);
        twoSideLinkedList.insertFirst(2);
        twoSideLinkedList.insertFirst(1);
        twoSideLinkedList.insertLast(3);
        twoSideLinkedList.insertLast(2);
        twoSideLinkedList.insertLast(3);
        twoSideLinkedList.insertLast(1);
        twoSideLinkedList.removeLast(3);
        twoSideLinkedList.display(); //[1, 2, 3, 3, 2, 1]
        twoSideLinkedList.removeFirst();
        twoSideLinkedList.removeLast();
        twoSideLinkedList.display(); //[2, 3, 3, 2]
        twoSideLinkedList.remove(3);
        twoSideLinkedList.display(); //[2, 3, 2]
        System.out.println(twoSideLinkedList.getLast());//2

        // Stack
        Stack<Integer> stack = new StackImpl<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display(); //[5, 4, 3, 2, 1]

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        //Deque
        Deque<Integer> deque = new DequeImpl<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.pollLast(); //todo
        deque.display();

    }
}
