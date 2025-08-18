package deque;

public class Test {
    public static void main(String[] args) {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>();
        deque.addFirst(1);
        deque.addFirst(1);
        deque.addFirst(1);
        deque.printDeque();
    }
}
