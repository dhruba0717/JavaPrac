package Arrays.Searching;

import java.util.Arrays;

public class LinearSearch {




    public static void main(String[] args) {
        int[] list = {3,6,4,8,4,9,5,-6,0};
        int[][] list2d = {
                {3,5,677},
                {54,76,23,22,435,665},
                {0,1},
        };
        System.out.println(searchInString("Dhrubaa",'a'));
        System.out.println(getItemIndex(list,0));
        System.out.println(getMin(list));
        System.out.println(searchIn2DArray(list2d,665));
        System.out.println(Arrays.toString(searchIn2DArrayReturnIndex(list2d,23)));
        System.out.println(max(list2d));
        System.out.println(even(23455));
        System.out.println(getNoOfDigits(23455));
    }

    // search in 2d array
//    {
//        {3,5,677},
//        {54,76,23,22,435,665},
//        {0,1},
//    };



    // search array return index if item found
    // else return -1
    static int getItemIndex(int[] arr, int num){
        int index = -1;
        for(int i=0; i<arr.length; i++)
            if (arr[i]== num)
                index = i;
        return index;
    }

    // search for a char in string
    static boolean searchInString(String s, char c)
    {
        if(s.isEmpty()){
            return false;
        }
        for(int i=0; i<s.length(); i++){
            if (c == s.charAt(i)){
                return true;
            }
        }
        return false;

    }

    static int getMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i : arr){
            if( i< min){
                min = i;
            }
        }
        return min;
    }

    // search in 2d array if found return index else return -1
    private static int[] searchIn2DArrayReturnIndex(int[][] list2d, int target) {
        for(int i =0; i< list2d.length; i++){
            for(int j = 0; j< list2d[i].length ; j++){
                if(list2d[i][j] == target){
                    return new int[]{i,j};
                }
            }

        }
        return new int[]{-1,-1};
    }


    // enhanced for loop
    private static boolean searchIn2DArray(int[][] list2d, int target) {

        for (int[] arr : list2d){
            for(int i : arr){
                if(i == target){
                    return true;
                }
            }
        }
        return false;
    }

    //max in 2d array
    private static int max(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for(int i =0; i< arr.length; i++){
            for(int j = 0; j< arr[i].length ; j++){
                if(arr[i][j]>max){
                    max = arr[i][j];
                }
            }

        }
        return max;
    }


    //Given an array nums of integers,
    // return how many of them contain an even number of digits

    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i : nums){
            if(even(i)){
                count++;
            }
        }
        return count;
    }

    static boolean even(int i) {
        int dig = 0;
        while (i>0){
            dig++;
            i=i/10;
        }
        return dig % 2 == 0;
    }

    // naive approch
//    public int findNumbers(int[] nums) {
//        int count = 0;
//        for(int i: nums){
//            if(String.valueOf(i).toCharArray().length %2 == 0){
//                count++;
//            }
//        }
//        return count;
//    }

    static int getNoOfDigits(int i){
        // shortcut
        return (int) (Math.log10(i)+1);
    }















}
