package deque;

public class LinkedListDeque<T> {
    private Node sentFront;
    private Node sentLast;
    private int size;

    private class Node {
        Node prev;
        Node next;
        T item;

        Node(Node p, Node n, T i) {
            prev = p;
            next = n;
            item = i;
        }

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

    public void addFirst(T item) {
        Node first = new Node(item);
        first.prev = sentFront;
        first.next = sentFront.next;
        sentFront.next.prev = first;
        sentFront.next = first;
        size++;
    }

    public void addLast(T item) {
        Node last = new Node(item);
        last.next = sentLast;
        last.prev = sentLast.prev;
        sentLast.prev.next = last;
        sentLast.prev = last;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentFront.next;
        while (p != null && p != sentLast) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

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

    public T get(int index) {
        if (index < 0 || index > size) {
            return null;
        }

        Node p = sentFront.next;

        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.item;
    }

//    public Iterator<T> iterator()

//    public boolean equals(Object o)
}
