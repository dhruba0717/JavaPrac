package Arrays.Sorting;

import java.util.Arrays;

public class CyclicSort {

    public static void main(String[] args) {
        int[] arr= {3,5,2,1,4};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void cyclicSort(int[] arr) {
        //{3,5,2,1,4};
        int i = 0;
        while (i < arr.length){
            if(arr[i] -1 != i){
                elementSwapInArrayByPosition(arr,i,arr[i]-1);
            } else { i++; }
        }
    }

    // fynction to swap position of two index in a list
    public static void elementSwapInArrayByPosition(int[] arr, int e1, int e2){
        int temp = arr[e1];
        arr[e1] = arr[e2];
        arr[e2] = temp;
    }
}