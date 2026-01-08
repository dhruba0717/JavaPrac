package Arrays.Sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
//        int[] arr = {1,2,3,4,5};
//        bubbleSort(arr);
        selSort(arr);
        System.out.println("Sorted array --->" + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        // compare previous item with next if not small swap
        // i runs till length of array - i means how many set of repitition to be done

        //check if already sorted then break the loop
        boolean swapped;

        for (int i = 0; i < arr.length; i++) {
            // j runs from 2nd element till last depending on i (after 1st repitition highest element goes to end hence no need
            // to compare that
            swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if(arr[j]<arr[j-1]){
                    // swap if next item smaller
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }

            // if no swap done for particular i then its a sorted array
            if(!swapped){
                break;
            }
        }

    }

    public static int[] selectionSort(int[] arr){

        // find min in array
        // swap to the first position

        for(int i=0; i<arr.length; i++){
            swapArrayByIndex(arr,i,minIndexOfArrayFromIndex(arr,i,arr.length));
        }

        return arr;

    }

    private static void swapArrayByIndex(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int minIndexOfArrayFromIndex(int[] arr, int start, int end) {
        int minIndex = start;
        for(int i= start+1; i<end ;i++){
            if(arr[i]<arr[minIndex])
                minIndex = i;
        }
        return minIndex;
    }


    public static void bubbleSort1(int[] arr) {

        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 1; j < arr.length; j++) {

                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;

        }
    }
    public static int[] selSort(int[] arr) {

        // find min in array and swap with first element
        for (int i = 0; i < arr.length-1; i++) {
            swapByIndex(i,findMinIndexInRange(i,arr.length-1,arr),arr);
        }
        return arr;
    }

    private static void swapByIndex(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int findMinIndexInRange(int i, int j, int[] arr) {
        int minIndex = i;
        for (int k = i; k <= j; k++) {
            if(arr[k]<arr[minIndex]) minIndex = k;
        }
        return minIndex;
    }
}
