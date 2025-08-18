package MultithreadingPractice;

public class SharedResource {


    // let this be a shared object which is used by more than 1 thread
    public static Object sharedObject = new Object();

    public static void main(String[] args) {

        // create 2 threads

        Runnable thread1 = () -> {
            int var = 2;
            System.out.println("from thread1 -> " +sharedObject.hashCode());
        };

        Runnable thread2 = () -> {
            int var = 2;
            System.out.println("from thread2 -> " +sharedObject.hashCode());
        };

        Thread obj1Thread = new Thread(thread1 , "runnableThread1");
        Thread obj2Thread = new Thread(thread2 , "runnableThread2");
        obj1Thread.start();
        obj2Thread.start();

        // both hash code is same as it is trying to access the same object

    }




}
