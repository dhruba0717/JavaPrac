package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int[] arr = new int[5];           // allocate heap with all value 0 and ref num of heap
//        int[] arr;      // only allocate the stack

        // take input for an array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }

        // print the array
        for(int i : arr){           // enhanced for loop
            System.out.println(i);
        }


        // 2D Arrays
        int[][] arr2 = new int[3][3];
        // giving the number of row is mandatory not column (Java treats this as array of arrays)
        // in heap 3 memory is allocated to 3 arrays which can have variable length


        // take input for 2d array

        for (int row = 0; row < arr2.length; row++) {
            for (int col = 0; col < arr2[row].length; col++) {
                // take input here
            }
        }

        // output
        for(int[] arrIn : arr2){
            System.out.println(Arrays.toString(arrIn));
        }

    }

    // arr {3,2,6,4,5}
//    static int[] sortArr(int[] arr){
//        for(int i =0;i< arr.length -1; i++){
//
//        }
//    }

    static int minInArray(int[] arr, int start, int end){
        int min = arr[0];
        for(int i=start ; i<=end; i++){
            if (arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }




}
