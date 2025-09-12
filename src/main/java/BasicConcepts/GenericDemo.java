package BasicConcepts;

public class GenericDemo {

    public static void main(String[] args) {

        Printer<Integer> intPrinter = new Printer<>(222);
        intPrinter.print();

        Printer<String> stringPrinter = new Printer<>("Dhruba");
        stringPrinter.print();
    }
}

// class printer is generic and we can pass any type
class Printer<T>{

    T thingToPrint;

    public Printer(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print(){
        System.out.println(thingToPrint);
    }
}
