package deque;

public class ArrayDeque<T> {
    private T items[];
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            T[] newItems = (T[]) new Object[items.length * 2];
            System.arraycopy(items, 0, newItems, 1, size);
            items = newItems;
        }

        items[0] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            T[] newItems = (T[]) new Object[items.length * 2];
            System.arraycopy(items, 0, newItems, 0, size);
            items = newItems;
        }

        items[size] = item;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T x = items[0];

        if (items.length >= 8 && (double) size / items.length <= 0.25) {
            T[] newItems = (T[]) new Object[items.length / 2];
            System.arraycopy(items, 1, newItems, 0, size - 1);
        }
        System.arraycopy(items, 1, items, 0, size - 1);

        items[size - 1] = null;
        size--;

        return x;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        if (items.length >= 8 && (double) size / items.length <= 0.25) {
            T[] newItems = (T[]) new Object[items.length / 2];
            System.arraycopy(items, 0, newItems, 0, size - 1);
        }
        System.arraycopy(items, 0, items, 0, size - 1);

        T x = items[size - 1];
        items[size - 1] = null;
        size--;

        return x;
    }

    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }

        return items[index];
    }
}
