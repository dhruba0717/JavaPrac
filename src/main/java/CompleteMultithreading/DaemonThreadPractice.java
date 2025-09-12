package CompleteMultithreading;

public class DaemonThreadPractice {

    public static void main(String[] args) {
        // set Daemon -> True - tell main thread to not depend on other thread to end
        // use for background tasks -> Garbage collection / logging
        System.out.println("Main thread started");

        DaemonThread daemonThread = new DaemonThread();
        // tells main thread to not wait for daemon thread to finish
        daemonThread.setDaemon(true);
        daemonThread.start();

        System.out.println("Main Thread finished");
    }
}

class DaemonThread extends Thread{

    @Override
    public void run() {
        while (true){
            System.out.println("Daemon thread is running");
        }
    }
}
