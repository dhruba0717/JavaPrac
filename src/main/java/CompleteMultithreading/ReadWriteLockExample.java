package CompleteMultithreading;

import java.util.concurrent.locks.ReentrantReadWriteLock;

//The key idea is:
//Multiple readers can read at the same time (no problem).
//Only one writer can write at a time (exclusive access).
//While writing, no reader is allowed.

class SharedData {
    private int number = 0;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    // Read method (many threads can do this together)
    public void readNumber() {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " reading: " + number);
            Thread.sleep(500); // simulate reading time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            rwLock.readLock().unlock();
        }
    }

    // Write method (only one thread can do this, exclusive)
    public void writeNumber(int value) {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " writing: " + value);
            number = value;
            Thread.sleep(1000); // simulate writing time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            rwLock.writeLock().unlock();
        }
    }
}
public class ReadWriteLockExample {

    public static void main(String[] args) {
        SharedData data = new SharedData();

        // Writer thread
        Thread writer = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                data.writeNumber(i * 10);
            }
        }, "Writer");

        // Reader threads
        Runnable readerTask = () -> {
            for (int i = 0; i < 5; i++) {
                data.readNumber();
            }
        };
        Thread reader1 = new Thread(readerTask, "Reader-1");
        Thread reader2 = new Thread(readerTask, "Reader-2");

        // Start everything
        writer.start();
        reader1.start();
        reader2.start();
    }
}


