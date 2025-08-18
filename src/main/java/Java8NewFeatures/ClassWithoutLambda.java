package Java8NewFeatures;

public class ClassWithoutLambda implements MathOperation{

    @Override
    public int operation(int a, int b) {
        return a+b;
    }
}



// functional interface can have only one abstract method
@FunctionalInterface
interface MathOperation{

    int operation(int a, int b);


    // not allowed int substract(int a, int b);
}
