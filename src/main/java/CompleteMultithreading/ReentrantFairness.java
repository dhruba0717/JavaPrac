package CompleteMultithreading;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//By default, ReentrantLock is unfair → it may allow some threads to “jump the queue”
// and get the lock before others waiting longer.
//With fairness enabled (new ReentrantLock(true)), threads get the lock in order (FIFO).
public class ReentrantFairness {
    public static void main(String[] args) {

    // Change to (false) to see unfair behavior
    TicketCounter counter = new TicketCounter(true); // fair lock

    Runnable task = () -> {
        for (int i = 0; i < 2; i++) {
            counter.getTicket();
        }
    };

    Thread t1 = new Thread(task, "Person-1");
    Thread t2 = new Thread(task, "Person-2");
    Thread t3 = new Thread(task, "Person-3");

        t1.start();
        t2.start();
        t3.start();
}
}

class TicketCounter {
    private final Lock lock;

    public TicketCounter(boolean fair) {
        this.lock = new ReentrantLock(fair);
    }

    public void getTicket() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " got the ticket");
            Thread.sleep(500); // simulate time to issue ticket
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}
