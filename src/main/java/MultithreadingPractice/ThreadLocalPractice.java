package MultithreadingPractice;

public class ThreadLocalPractice {

    // suppose for an web app for 1 thread we want to store some local values (user based)
    // other thread will have other values

    public static void main(String[] args) {

        // this ThreadLocal is specific to specific thread value of one thread Local the other thread doesnt know

        ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();
        longThreadLocal.set(1234L);
        Runnable thread1 = () -> {
            longThreadLocal.set(4567L);
            System.out.println(longThreadLocal.get());
        };

        Runnable thread2 = () -> {
            longThreadLocal.set(7896L);
            System.out.println(longThreadLocal.get());

            // removes the local variable
            longThreadLocal.remove();
            System.out.println(longThreadLocal.get());
        };

        Thread objThread1 = new Thread(thread1);
        Thread objThread2 = new Thread(thread2);

        objThread1.start();
        objThread2.start();


    }
}