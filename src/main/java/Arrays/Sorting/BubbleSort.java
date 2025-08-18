package Arrays.Sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
//        int[] arr = {1,2,3,4,5};
        bubbleSort(arr);
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

}
