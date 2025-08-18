package Java8NewFeatures;

import java.util.Optional;

public class OptionalPractice {

    public static String getName() {
        // Simulate null or actual name
        return null;
        // return xyz;
    }

    public static void main(String[] args) {
        // before java 8
//        String name = getName();
//        if (name != null) {
//            System.out.println(name.toUpperCase());
//        }

        // after java 8
//        Optional<String> name = getName();
//        name.ifPresent(n -> System.out.println(n.toUpperCase()));
    }
}
