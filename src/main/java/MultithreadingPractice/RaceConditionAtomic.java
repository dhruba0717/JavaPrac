package MultithreadingPractice;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionAtomic {

    // when 2 thread incrememnt a single object it doesnt work properly

//    public static int count;
//public static int getCount() {
//    return count;
//}
//
//    public static void incrememntCount() {
//        count++ ;
//    }

    // use Atomic keyword to solve

    public static AtomicInteger count = new AtomicInteger(0);
//static Integer count = new Integer(0);
    public static int getCount() {
        return count.get();
    }

    public static void incrememntCount() {
        count.incrementAndGet() ;
    }

    public static void main(String[] args) {


        // 2 thread icremeting count 50000 times so answer should be 100000
        Runnable thread1 = () -> {
            System.out.println("Thread1 started");
            for (int i = 0; i < 50000; i++) {
                incrememntCount();
            }
            System.out.println("Thread 2 logic completed");
            System.out.println(getCount());
        };

        Runnable thread2 = () -> {
            System.out.println("Thread 2 started");
            for (int i = 0; i < 50000; i++) {
                incrememntCount();
            }
            System.out.println("Thread 2 logic completed");
            System.out.println(getCount());
        };

        Thread objThread1 = new Thread(thread1);
        Thread objThread2 = new Thread(thread2);

        objThread1.start();
        objThread2.start();

    }
}
