public class LinkedListQueue<T> implements Queue<T> {

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

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(T element) {
        if (tail == null) {
            tail = new Node(element);
            head = tail;
        } else {
            tail.next = new Node(element);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null)
            tail = null;
        size--;

        return retNode.element;
    }

    @Override
    public T getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");

        return head.element;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
