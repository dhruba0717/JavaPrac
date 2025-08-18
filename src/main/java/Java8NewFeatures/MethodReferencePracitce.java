package Java8NewFeatures;
import java.util.Arrays;
public class MethodReferencePracitce {


    //In Java, method reference is a shorthand notation of a lambda expression to call a method. It allows
    //you to refer to a method without executing it, and it can be used to make your code more readable and concise.

    public static int compareNumbers(int a, int b) {
        return Integer.compare(a, b);
    }

    public static void main(String[] args) {
        Integer[] numbers = {5, 3, 9, 1};
        Arrays.sort(numbers, MethodReferencePracitce::compareNumbers);
        // same as (a, b) -> MethodReferencePracitce.compareNumbers(a, b)
        System.out.println(Arrays.toString(numbers));

    }



}
