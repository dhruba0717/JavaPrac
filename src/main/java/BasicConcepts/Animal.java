package BasicConcepts;


public interface Animal {

    // only has abstract methods
    void bark();

    // can have default method - no need to override
    default void run(String name){
        System.out.println(name+" is running");
    }



}


