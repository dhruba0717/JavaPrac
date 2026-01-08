package SingletonPractice;

public class ThreadSafeSingleton {

    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
        System.out.println("Singleton instance created!");
    }

    public static ThreadSafeSingleton getInstance() {
        // check locking
        synchronized (ThreadSafeSingleton.class){
            if (instance == null) {  // create only once
                instance = new ThreadSafeSingleton();
            }
        }

        return instance;
    }

}
