package MultithreadingPractice;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionSynchronized {

    // when 2 thread incrememnt a single object it doesnt work properly
    // use synchronized methods - lock based

    // atomic is faster

    public static int count;
public static int getCount() {
    return count;
}

    public static synchronized void incrememntCount() {
        count++ ;

        // can make only a specific part of function aso synchronized
//        synchronized (RaceConditionSynchronized.class){
//            count++;
//        }
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
