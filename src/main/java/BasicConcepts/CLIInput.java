package BasicConcepts;

import java.util.ArrayList;
import java.util.Scanner;

public class CLIInput {

    // learn taking input from CLI needed for DSA

    public static void main(String[] args) {

        // take cli input through scanner class
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number : ");
        int num1 = sc.nextInt();
        System.out.println("Enter second number : ");
        int num2 = sc.nextInt();

        System.out.println(swap(num1,num2));
    }

    static ArrayList<Integer> swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(a);
        integers.add(b);
        return integers;
    }

}
