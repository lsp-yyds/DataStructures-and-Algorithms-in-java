import java.util.Random;

public class QueueTest {

    private static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();

        for (int i = 0; i < opCount; i++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));

        for (int i = 0; i < opCount; i++)
            q.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        LinkedListQueue<Integer> queue3 = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue3.enqueue(i);
            System.out.println(queue3);

            if (i % 3 == 2) {
                queue3.dequeue();
                System.out.println(queue3);
            }
        }

        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }

        CircularQueue<Integer> queue2 = new CircularQueue<>();
        for (int i = 0; i < 10; i++) {
            queue2.enqueue(i);
            System.out.println(queue2);

            if (i % 3 == 2) {
                queue2.dequeue();
                System.out.println(queue2);
            }
        }

        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        CircularQueue<Integer> circularQueue = new CircularQueue<>();
        double time2 = testQueue(circularQueue, opCount);
        System.out.println("CircularQueue, time: " + time2 + " s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(circularQueue, opCount);
        System.out.println("LinkedListQueue, time: " + time3 + " s");
    }
}
