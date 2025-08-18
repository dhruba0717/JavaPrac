package Recursion;

public class Recursion {

    public static void main(String[] args) {
//        System.out.println(fibonacci(10));
        int[] arr = {1, 5, 7, 21, 42, 68, 73};
        System.out.println(binarySearchUsingRecursion(arr,7, 0, arr.length -1));
    }

    // nth Fibonacci number
    // 0 1 1 2 3 5 8 13 21 34 .....

    public static int fibonacci(int n){
        if(n<2){
            return n;
        }
        else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    // binary search using recursion
    // returns the element index
    public static int binarySearchUsingRecursion(int[] arr, int n, int s , int e) {
        int m = e + (s-e)/2;

        if(arr[m] == n){
            return m;
        } else if (arr[m] > n ) {
            return binarySearchUsingRecursion(arr, n , s , m-1);
        } else {
            return binarySearchUsingRecursion(arr, n , m+1, e);
        }
    }
}
