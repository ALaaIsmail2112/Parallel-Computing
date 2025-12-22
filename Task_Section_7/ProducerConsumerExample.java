import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class ProducerConsumerExample {

    private static final int CAPACITY = 5;
    private final Queue<String> buffer = new LinkedList<>();

    private final ReentrantLock lock = new ReentrantLock(true);
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    // ================= PRODUCER =================
    class Producer implements Runnable {
        private final String name;

        Producer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            int count = 1;

            try {
                while (true) {
                    lock.lock();

                    try {
                        while (buffer.size() == CAPACITY) {
                            System.out.println(name + " waiting, buffer is full...");
                            notFull.await();
                        }

                        String message = name + "-Message-" + count++;
                        buffer.add(message);
                        System.out.println(name + " produced: " + message);

                        notEmpty.signalAll();
                    } finally {
                        lock.unlock();
                    }

                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // ================= CONSUMER =================
    class Consumer implements Runnable {
        private final String name;

        Consumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    lock.lock();

                    try {
                        while (buffer.isEmpty()) {
                            System.out.println(name + " waiting, buffer is empty...");
                            notEmpty.await();
                        }

                        String message = buffer.poll();
                        System.out.println(name + " consumed: " + message);

                        notFull.signalAll();
                    } finally {
                        lock.unlock();
                    }

                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        ProducerConsumerExample example = new ProducerConsumerExample();

        Thread producer1 = new Thread(example.new Producer("Producer-1"));
        Thread producer2 = new Thread(example.new Producer("Producer-2"));

        Thread consumer1 = new Thread(example.new Consumer("Consumer-1"));
        Thread consumer2 = new Thread(example.new Consumer("Consumer-2"));

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
