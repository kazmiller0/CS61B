package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> {
    private final Node sentFront;
    private final Node sentLast;
    private int size;

    private class Node {
        Node prev;
        Node next;
        T item;

        Node(T i) {
            prev = null;
            next = null;
            item = i;
        }

        Node() {
            prev = null;
            next = null;
            item = null;
        }
    }

    public LinkedListDeque() {
        size = 0;
        sentFront = new Node();
        sentLast = new Node();

        sentFront.next = sentLast;
        sentLast.prev = sentFront;
    }

    @Override
    public void addFirst(T item) {
        Node first = new Node(item);
        first.prev = sentFront;
        first.next = sentFront.next;
        sentFront.next.prev = first;
        sentFront.next = first;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node last = new Node(item);
        last.next = sentLast;
        last.prev = sentLast.prev;
        sentLast.prev.next = last;
        sentLast.prev = last;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (Node p = sentFront.next; p != sentLast; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (sentFront.next == sentLast) {
            return null;
        }

        Node p = sentFront.next;
        sentFront.next = p.next;
        sentFront.next.prev = sentFront;
        size--;

        return p.item;
    }

    @Override
    public T removeLast() {
        if (sentLast.prev == sentFront) {
            return null;
        }

        Node p = sentLast.prev;
        sentLast.prev = p.prev;
        sentLast.prev.next = sentLast;
        size--;

        return p.item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }

        Node p = sentFront.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.item;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
