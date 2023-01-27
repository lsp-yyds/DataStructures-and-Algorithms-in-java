public class CircularQueue<T> implements Queue<T> {

    private T[] data;
    private int front, tail;
    private int size;

    public CircularQueue(int capacity) {
        data = (T[]) new Object[capacity + 1];
        front = tail = 0;
        size = 0;
    }

    public CircularQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(T element) {
        if ((tail + 1) % data.length == front)
            changeQueueLength(getCapacity() * 2);

        data[tail] = element;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void changeQueueLength(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++)
            newData[i] = data[(front + i) % data.length];
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        T temp = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            changeQueueLength(getCapacity() / 2);

        return temp;
    }

    @Override
    public T getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty");

        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
