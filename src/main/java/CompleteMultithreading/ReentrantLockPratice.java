package CompleteMultithreading;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class ReentrantLockPratice {

//    A Reentrant Lock in Java is a type of lock that allows a thread to acquire the same lock multiple times
//    without causing a deadlock. If a thread already holds the lock, it can re-enter the lock without being blocked.
//    This is useful when a thread needs to repeatedly enter synchronized blocks or methods within the same execution flow.

    private final Lock lock = new ReentrantLock();

    public void outerMethod() {
        lock.lock();
        try {
            System.out.println("Outer method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    public void innerMethod() {
        lock.lock();
        try {
            System.out.println("Inner method");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockPratice example = new ReentrantLockPratice();
        example.outerMethod();
    }

}
