package Java8NewFeatures;

public class ClassWithLambda{

    // lambda implements functional innterface with less code


    public static void main(String[] args) {
        MathOperation2 sumoperation = (int a, int b) -> a+b;

        MathOperation2 substractOperation = (int a, int b) -> a-b;
        // no need to write complete method

        System.out.println(sumoperation.operation(3,4));
        System.out.println(substractOperation.operation(7,2));

    }

}



// functional interface can have only one abstract method
@FunctionalInterface
interface MathOperation2{

    int operation(int a, int b);


    // not allowed int substract(int a, int b);
}
