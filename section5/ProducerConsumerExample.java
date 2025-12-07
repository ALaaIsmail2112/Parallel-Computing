package section5;
import java.util.LinkedList;
import java.util.Queue;
public class ProducerConsumerExample {

    // Shared buffer
    private final Queue<String> buffer = new LinkedList<>();
    private final int capacity = 5;

    // Producer Thread
    class Producer extends Thread {
        private final String name;

        Producer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            int messageCount = 0;

            while (true) {
                synchronized (buffer) {
                    while (buffer.size() == capacity) {
                        try {
                            System.out.println(name + " waiting → Buffer full");
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    String msg = name + " message " + (++messageCount);
                    buffer.add(msg);
                    System.out.println(name + " produced: " + msg);

                    buffer.notifyAll();
                }

                try { Thread.sleep(500); } 
                catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    // Consumer Thread
    class Consumer extends Thread {
        private final String name;

        Consumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {

            while (true) {
                synchronized (buffer) {
                    while (buffer.isEmpty()) {
                        try {
                            System.out.println(name + " waiting → Buffer empty");
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    String msg = buffer.remove();
                    System.out.println(name + " consumed: " + msg);

                    buffer.notifyAll();
                }

                try { Thread.sleep(700); } 
                catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        ProducerConsumerExample example = new ProducerConsumerExample();

        Producer p1 = example.new Producer("Producer-1");
        Producer p2 = example.new Producer("Producer-2");

        Consumer c1 = example.new Consumer("Consumer-1");
        Consumer c2 = example.new Consumer("Consumer-2");
        Consumer c3 = example.new Consumer("Consumer-3");

        p1.start();
        p2.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
