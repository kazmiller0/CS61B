public class LinkedListDeque<Character> implements Deque<Character> {
    /**
     * inner class Node.
     */
    public class Node {
        /**
         * the item stored on this node.
         */
        private Character item;
        /**
         * the Node before this Node.
         **/
        private Node pre;
        /**
         * the Node after this Node.
         **/
        private Node next;

        /**
         * constructor for Node.
         */
        public Node(Character n, Node ppre, Node nnext) {
            item = n;
            pre = ppre;
            next = nnext;
        }

        /**
         * constructor for Node.(especially for sentinel node).
         */
        public Node(Node ppre, Node nnext) {
            pre = ppre;
            next = nnext;
        }
    }

    /**
     * sentinel node.
     */
    private Node sentinel;
    /**
     * size of the deque.
     */
    private int size;

    /**
     * constructor for deque.
     */
    public LinkedListDeque() {
        sentinel = new Node(null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
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
    public void addFirst(Character item) {
        Node newList = new Node(item, sentinel, sentinel.next);
        sentinel.next.pre = newList;
        sentinel.next = newList;
        size++;
    }

    @Override
    public void addLast(Character item) {
        Node newList = new Node(item, sentinel.pre, sentinel);
        sentinel.pre.next = newList;
        sentinel.pre = newList;
        size++;
    }

    @Override
    public Character removeFirst() {
        if (size == 0) {
            return null;
        }
        Character ret = sentinel.next.item;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return ret;
    }

    @Override
    public Character removeLast() {
        if (size == 0) {
            return null;
        }
        Character ret = sentinel.pre.item;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        size--;
        return ret;
    }

    @Override
    public Character get(int index) {
        if (index >= size) {
            return null;
        }
        Node ptr = sentinel;
        for (int i = 0; i <= index; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    private Character getRecursiveHelp(Node start, int index) {
        if (index == 0) {
            return start.item;
        } else {
            return getRecursiveHelp(start.next, index - 1);
        }
    }

    public Character getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelp(sentinel.next, index);
    }

    @Override
    public void printDeque() {
        Node ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
    }
}