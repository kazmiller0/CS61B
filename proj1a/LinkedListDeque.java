public class LinkedListDeque<T> {
    private Node sentinel;
    private int size;

    public class Node {
        private T item;
        private Node prev;
        private Node next;

        public Node(T x, Node p, Node n) {
            item = x;
            prev = p;
            next = n;
        }

        public Node(Node p, Node n) {
            prev = p;
            next = n;
        }
    }

    public LinkedListDeque() {
        sentinel = new Node(null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    public void printDeque() {
        Node p = sentinel;
        p = p.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T item = null;
        item = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        T item = null;
        item = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return item;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }

        Node p = sentinel;
        p = p.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    public static void main(String[] args) {
        LinkedListDeque<String> L = new LinkedListDeque<>();
        L.addFirst("hello");
        L.addLast("word");
        L.addLast("123");
        L.addLast("321");
        System.out.println(L.size());
        L.printDeque();
        System.out.println(L.get(3));
        System.out.println(L.removeFirst());
        System.out.println(L.removeLast());
    }
}
