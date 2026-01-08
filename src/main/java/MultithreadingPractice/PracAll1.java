package MultithreadingPractice;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

// prac - synch / atomic integer / volatile
public class PracAll1 {
    static int x = 0;
//    public static void incrementX(){
//        x++;
//    }

    // sol with synchronized
//    static int x = 0;
//    public static synchronized void incrementX(){
//        x++;
//    }

    // sol with Atomic integer
//    static AtomicInteger x = new AtomicInteger(0);

    // using lock
    private static ReentrantLock lock = new ReentrantLock();

    public static void incrementX() {
        lock.lock();  // acquire lock
        try {
            x++;
        } finally {
            lock.unlock(); // release lock (MUST)
        }
    }
   public static void main(String[] args) throws InterruptedException {

        // ways to create thread
//        Thread t1 = new Thread(() -> {
//            System.out.println("t1 thread is running");
//        });
//
//        t1.start();
//
//        Runnable r1 = new Thread(() -> {
//            System.out.println("r1 is running");
//        });
//        r1.run();
//
//        System.out.println("main thread running");

        // race condition

        Thread t1 = new Thread(() ->
        {
            for (int i = 0; i < 10000; i++){
                incrementX();
//                x.incrementAndGet();
            }
        });
        Thread t2 = new Thread(() ->
        {
            for (int i = 0; i < 10000; i++) {
                incrementX();
//                x.incrementAndGet();   -> use in case of atomic integer
            }
        });
        t1.start();
        t2.start();
        // wait for both threads to finish (so that main doesnt finish first)
        t1.join();
        t2.join();
        System.out.println("value of x after incrementing by 2 threads : "+x);
    }
}
