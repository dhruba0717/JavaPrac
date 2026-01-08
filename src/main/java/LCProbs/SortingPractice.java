package LCProbs;

public class SortingPractice {

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8, 3};

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        arr = selectionSort(arr); // You will implement this function

        System.out.println("\nSorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

//    public static int[] bubbleSort(int[] arr){
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length- i -1; j++) {
//                if(arr[j] > arr[j+1]){
//                    //swap elements
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//        return arr;
//    }

    public static int[] selectionSort(int[] arr)
    {

        // find min and replace with first index
        for (int i = 0; i < arr.length; i++) {
            int min = findMinValueIndexInArrayWithIndex(arr,i,arr.length -1);
            swapArrayWithIndex(arr,i,min);
        }
        return arr;
    }

    private static void swapArrayWithIndex(int[] arr, int i, int min) {
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }

    private static int findMinValueIndexInArrayWithIndex(int[] arr, int i, int j) {
        int minIndex = i;
        for (int k = i; k <= j; k++) {
            if(arr[k]< arr[minIndex]) minIndex = arr[k];
        }
        return minIndex;
    }


}
