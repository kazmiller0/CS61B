package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {

    private class ArrayDequeIterator implements Iterator<T> {
        int index;

        ArrayDequeIterator() {
            index = -1;
        }

        @Override
        public boolean hasNext() {
            return index < size - 1;
        }

        @Override
        public T next() {
            index++;
            return items[index];
        }
    }

    private T[] items;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }

        System.arraycopy(items, 0, items, 1, size);
        items[0] = item;
        size++;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }

        items[size] = item;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T x = get(0);
        System.arraycopy(items, 1, items, 0, size - 1);
        items[size - 1] = null;
        size--;

        if (items.length >= 16 && (double) size / items.length <= 0.25) {
            resize(items.length / 2);
        }

        return x;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        T x = items[size - 1];
        items[size - 1] = null;
        size--;

        if (items.length >= 16 && (double) size / items.length <= 0.25) {
            resize(items.length / 2);
        }

        return x;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }

        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ArrayDeque<T> other = (ArrayDeque<T>) o;
        if (size != other.size) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (items[i].equals(other.items[i])) {
                return false;
            }
        }

        return true;
    }
}
