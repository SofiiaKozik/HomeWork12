import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Task2 {
    private final int n = 15;
    public static volatile AtomicInteger number = new AtomicInteger(1);
    public BlockingQueue<String> result = new LinkedBlockingQueue<>();

    public synchronized void addFizz() {
        while (number.get() <= n) {
            if (number.get() % 3 == 0 && number.get() % 5 != 0) {
                result.add("fizz");
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public synchronized void addBuzz() {
        while (number.get() <= n) {
            if (number.get() % 3 != 0 && number.get() % 5 == 0) {
                result.add("buzz");
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public synchronized void addFizzBuzz() {
        while (number.get() <= n) {
            if (number.get() % 3 == 0 && number.get() % 5 == 0) {
                result.add("fizzbuzz");
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public synchronized void addNumbers() {
        while (number.get() <= n) {
            if (number.get() % 3 != 0 && number.get() % 5 != 0) {
                result.add(String.valueOf(number));
                number.incrementAndGet();

            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            while (!result.isEmpty()) {
                System.out.println(result.poll());
            }
            notifyAll();
            }
        }
    }
