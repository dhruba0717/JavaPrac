package MultithreadingPractice;

public class Practice {

    public static void main(String[] args) throws InterruptedException {

        // multithreading concepts -> run 2 threads parallely
        // java.lang.Thread and java.util.concurrent
        // JVM uses OS level threads

        System.out.println("Main thread started");

//        Thread objThread = new MyThread();
        Thread objThread2 = new Thread(() -> {
            System.out.println("thread 2 running");
        });
        objThread2.start();

        // more efficient way is to use runnable to create thread
        // runnable is functional interface with only 1 method run()
//        Runnable runObject = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("runnable thread running");
//            }
//        };

        // can be written using lambda like
        Runnable runObject = () -> {
            System.out.println("runnable thread running");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());
            try {
                System.out.println("Sleep started");
                Thread.sleep(2000);
                System.out.println("Sleep ended");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread3 completed");
        };

        Thread objThread3 = new Thread(runObject , "Thread 3 running");

        // Make daemon - to make sure main thread doesnt wait for other thread to compleyte
        objThread3.setDaemon(true);
        objThread3.start();

        System.out.println("main thread ended");




    }


}

// this is legacy process

//class MyThread extends Thread{
//    public void run(){
//        System.out.println("My thread is running");
//    }
//}