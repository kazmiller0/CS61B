package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private T[] items;
    private int size;
    private final Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }

    public T max() {
        return max(comparator);
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }

        T max = null;
        for (T x : this) {
            if (c.compare(x, max) > 0) {
                max = x;
            }
        }

        return max;
    }
}
