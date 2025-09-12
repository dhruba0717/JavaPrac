package Problems;

import java.util.ArrayList;

public class PrimeUptoRange {

    public static void main(String[] args) {
        System.out.println(primeBetweenRange(44,20000000).toString());
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;          // check negative
        if (n == 2) return true;            // check 2
        if (n % 2 == 0) return false;       // check even - always non prime

        for (int i = 3; i <= Math.sqrt(n); i += 2) {            // start from 3 check for only odd nums
            if (n % i == 0) return false;
        }
        return true;
    }

//    Divisors of 100:
//1 × 100, 2 × 50, 4 × 25, 5 × 20, 10 × 10.
//
//Notice how after 10 (which is √100), factors start repeating in reverse order.
//So we only need to check up to 10

    public static ArrayList<Integer> primeBetweenRange(int start, int end) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) ans.add(i);
        }
        return ans;
    }
}
