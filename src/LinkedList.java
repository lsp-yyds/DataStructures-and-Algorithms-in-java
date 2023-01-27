public class LinkedList<T> {

    private class Node {
        public T element;
        public Node next;

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node(T element) {
            this(element, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illeal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        prev.next = new Node(element, prev.next);
        size++;
    }

    public void addFirst(T element) {
        add(0, element);
    }

    public void addLast(T element) {
        add(size, element);
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur.element;
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.element = element;
    }

    public boolean contains(T element) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.element.equals(element))
                return true;
            cur = cur.next;
        }
        return false;
    }

    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Removed failed. Index is illegal.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.element;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public void removeElement(T element) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.element.equals(element))
                break;
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");

        return res.toString();
    }
}
