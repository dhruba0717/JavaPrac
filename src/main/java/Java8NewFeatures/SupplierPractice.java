package Java8NewFeatures;

import java.util.function.Supplier;

public class SupplierPractice {


    // supplier is a func interface which doesnt takes nothing but returns
    // T get();
    public static void main(String[] args) {

        Supplier<String> s = () -> "Hellow world";

        System.out.println(s.get());


    }
}
