import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    // Shared buffer
    static class SharedBuffer {

        private final Queue<Integer> queue = new LinkedList<>();
        private final int capacity = 3;

        // Add item to buffer
        public synchronized void produce(int item) throws InterruptedException {

            // Wait if buffer is full
            while (queue.size() == capacity) {
                wait();
            }

            queue.add(item);
            System.out.println("Produced: " + item);

            // Notify consumer
            notify();
        }

        // Remove item from buffer
        public synchronized int consume() throws InterruptedException {

            // Wait if buffer is empty
            while (queue.isEmpty()) {
                wait();
            }

            int item = queue.remove();
            System.out.println("Consumed: " + item);

            // Notify producer
            notify();

            return item;
        }
    }

    public static void main(String[] args) {

        SharedBuffer buffer = new SharedBuffer();

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.produce(i);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.consume();
                    Thread.sleep(400);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Production and consumption completed.");
    }
}