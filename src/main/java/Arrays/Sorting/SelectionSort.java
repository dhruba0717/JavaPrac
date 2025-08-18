package Arrays.Sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {4,2,6,-1,0,3};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

//        System.out.println(maxOfArr(new int[]{2, 1, 3, 4, 5},0,2));
//        swapElements(arr,2,4);
//        System.out.println(Arrays.toString(arr));

    }

    // Selection sort - find max of the entire array replace with last element
    private static void selectionSort(int[] arr) {
        for (int i = arr.length -1; i > 0; i--) {
            int max = maxOfArr(arr,0,i);
            swapElements(arr,max,i);
        }
    }


    // return index where maximum (in a given range)
    public static int maxOfArr(int[] arr, int start, int end) {
        int maxIndex = 0;
        for (int i = start; i <= end; i++) {
            if(arr[i] > arr[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // fynction to swap position of two index in a list
    public static void swapElements(int[] arr, int e1, int e2){
        int temp = arr[e1];
        arr[e1] = arr[e2];
        arr[e2] = temp;
    }

}
