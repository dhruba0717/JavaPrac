package SingletonPractice;

//A Singleton is a design pattern where only one instance of a class
// can exist in the entire application — and it provides a global point of access to that instance.

public class SingletonWIthoutThread {
    private static SingletonWIthoutThread instance;

    private SingletonWIthoutThread() {
        System.out.println("Singleton instance created!");
    }

    public static SingletonWIthoutThread getInstance() {
        if (instance == null) {  // create only once
            instance = new SingletonWIthoutThread();
        }
        return instance;
    }
}

//The instance is created only when getInstance() is called the first time (lazy loading).
//
//Works fine in single-threaded environments.
