package CompleteMultithreading;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Locks used because synchronized keywork is default lock and it has many limitation
// it locks the entire method or block, leading to potential performance issues.
// It lacks a try-lock mechanism, causing threads to block indefinitely, increasing the risk of deadlocks.

public class LocksPratice {

    public static void main(String[] args) {

        // shared bank account for both t1 & t2
        BankAccount sbi = new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                sbi.withdraw(50);
            }
        };
        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        t1.start();
        t2.start();
    }
}

class BankAccount {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        try {
//            A ReentrantLock object is created in BankAccount.
//            This lock ensures only one thread at a time can execute the withdrawal logic.
//            tryLock(timeout, TimeUnit)
//            Instead of using lock.lock() (which waits indefinitely)
//            This means a thread will wait up to 1 second to acquire the lock.
//            If it fails to acquire within 1 second, it gives up and prints "could not acquire the lock, will try later".
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
                        Thread.sleep(3000); // Simulate time taken to process the withdrawal
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        //Ensures that the lock is always released, even if an exception occurs. - avoid deadlock
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try later");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
