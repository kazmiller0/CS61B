public interface Deque<Character> {
    void addFirst(Character item);

    void addLast(Character item);

    boolean isEmpty();

    int size();

    void printDeque();

    Character removeFirst();

    Character removeLast();

    Character get(int index);
}
