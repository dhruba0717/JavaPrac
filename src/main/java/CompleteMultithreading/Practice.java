package CompleteMultithreading;

public class Practice {

    // how to create thread
    // Thread extend or implement Runnable
    // if a class already extend some other class then implement Runnable else extend Thread
    public static void main(String[] args) {

        // main function already runs a main thread
        System.out.println("Main method thread name -> "+Thread.currentThread().getName());
        System.out.println("Main method thread state -> "+Thread.currentThread().getState());

        // create thread from Thread
        MyThread myThread = new MyThread();
        System.out.println("before starting thread state - > "+myThread.getState());
        myThread.start();
        System.out.println("after starting thread state - > "+myThread.getState());

        // create thread from Runnable
        MyThread2 myThread2 = new MyThread2();
        // runnable has no start method so create a Thread object of myThread2
        Thread myThread2Thread = new Thread(myThread2);
        myThread2Thread.start();

        // give name to a thread - parent constructor
        NameThisThread nameThisThread = new NameThisThread("Easy");
        nameThisThread.start();
        System.out.println(nameThisThread.getName() + " is "+nameThisThread.getState());


        // States of Thread -> NEW RUNNABLE WAITING TERMINATED

        // interrupt -> stop a thread
        nameThisThread.interrupt();
        System.out.println(nameThisThread.getName() + " is "+nameThisThread.getState());




    }


}
// Extend thread to create thread
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread is running ....");
    }
}
// Runnable implementation
class MyThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("My Thread2 is running");
    }
}
// Name a thread using constructor
class NameThisThread extends Thread{
    NameThisThread(String name){
        super(name);
    }

    @Override
    public void run() {
        super.run();
    }
}