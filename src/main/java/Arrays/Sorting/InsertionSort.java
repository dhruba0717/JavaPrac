package Arrays.Sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr= {3,5,2,1,4};
        insertioSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertioSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j > 0; j--) {
                if(j>=arr.length){
                    break;
                }
                if(arr[j]<arr[j-1]){
                    elementSwapInArrayByPosition(arr,j,j-1);
                } else { break; }
            }
        }

    }

    // fynction to swap position of two index in a list
    public static void elementSwapInArrayByPosition(int[] arr, int e1, int e2){
        int temp = arr[e1];
        arr[e1] = arr[e2];
        arr[e2] = temp;
    }

}
