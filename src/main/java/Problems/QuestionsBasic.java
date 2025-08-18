package Problems;

import java.util.Scanner;

public class QuestionsBasic {

    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        System.out.println("Enter number");
        System.out.println(isArmstrong(153));
//        System.out.println(getLength(567));

//        System.out.println(isPrime(83));
    }



    // write a function to tell if number is prime
    static boolean isPrime(int x){
        boolean b = false;
            if(x>=1){
                int c = 0;
                for(int i = 1; i<=x ; i++){

                    if(x%i == 0){
                        c++;
                    }
                }
                if(c==2){
                    b = true;
                }
            }
            return b;
    }

    // length of a number ex 153 - 3
    static int getLength(int x){
        int len = 0;
        while (x>=1){
            int ud = x%10;
            x = x/10;
            len++;
        }
        return len;
    }

    // Write a function to check if Armstrong num
    //a number that is equal to the sum of its own digits,
    // each raised to the power of the number of digits in the number
    // Ex 153 = 1^3 + 5^3 + 3^3
    static boolean isArmstrong (int x){
        int value = x;
        int sum = 0;
        int c = getLength(x);
        while(x>0){
            sum += Math.pow((x%10),c);
            x = x/10;
        }
        return sum == value;

    }











}
