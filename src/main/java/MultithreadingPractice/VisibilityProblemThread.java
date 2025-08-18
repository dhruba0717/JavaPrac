package MultithreadingPractice;

public class VisibilityProblemThread {

    // threads keep a local copy of variable from ram in cache
    // if thread2 picks it from main ram puts into cache ->  thread1 changes it the thread2 will not get the updated value to solve this use volatile
    public static volatile boolean flag = false;
    public void setFlag(boolean flag){
        this.flag = flag;
    }
    public boolean getFlag(){
        return flag;
    }
    public static void main(String[] args) {

        // create 2 threads one will set flag to true
        VisibilityProblemThread visibilityProblemThread = new VisibilityProblemThread();
        Runnable thread1 = () -> {
            System.out.println("Thread1 started");
            try {
                System.out.println("Thread 1 logic started");
                Thread.sleep(1000);
                System.out.println("Thread 1 logic completed");
                visibilityProblemThread.setFlag(true);
                System.out.println("Flag set by thread 1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        };

        Runnable thread2 = () -> {
            System.out.println("Thread 2 started");
            while (!visibilityProblemThread.getFlag()){
                // run until flag value is true
//                System.out.println("flag is still false");  we cant keep suysout here as it forces memory sync
            }
            System.out.println("Thread 2 logic completed");
        };

        Thread objThread1 = new Thread(thread1);
        Thread objThread2 = new Thread(thread2);

        objThread1.start();
        objThread2.start();

        // thread1 has updated the value of flag to true but thread1 still gets it false
        // to get the updated value use Volatile keyword



    }
}



//Why the loop never stops without the println
//Let’s walk through what’s happening:
//
//flag is a shared variable between Thread 1 and Thread 2.
//
//        In Java, each thread can keep its own cached copy of variables for speed (in CPU registers or thread-local memory).
//
//Thread 2 might read flag once at the start of the loop, store it in a CPU cache, and never fetch the updated value from main memory.
//
//When Thread 1 changes flag to true, that update is written to main memory, but Thread 2’s cached copy remains false — so it spins forever.
//
//Why uncommenting the System.out.println() makes it work
//Printing to the console forces a memory synchronization because:
//
//        System.out.println() involves I/O operations that flush memory caches (due to synchronized blocks inside PrintStream).
//
//That synchronization makes Thread 2 fetch the latest flag from main memory.
//
//        So effectively, your println() is accidentally acting like a volatile read.
