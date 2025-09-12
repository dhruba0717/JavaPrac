package CompleteMultithreading;

// 2 thread will work on this resource
// wait / notify / notifyAll
class SharedResource{
    private int data;
    private boolean hasData;

    synchronized void produce(int value) throws InterruptedException {
        // if there is already data dont add data let consumer consume that first
        while (hasData){
            wait();
        }
        data = value;
        hasData = true;
        notify();
        System.out.println("Produced -> "+ value);
    }

    synchronized int consume() throws InterruptedException {
        // if there is already data dont add data let consumer consume that first
        while (!hasData){
            wait();
        }
        hasData = false;
        notify();
        System.out.println("Consumed -> "+ data);
        return data;
    }
}

// There will be one producer one consumer
// when one produce data other will not consume
// once produce is done then only consume
public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        producer.start();
        consumer.start();
    }

}

class Producer extends Thread{

    SharedResource resource = new SharedResource();

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                resource.produce(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer extends Thread{

    SharedResource resource = new SharedResource();

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                int value = resource.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
