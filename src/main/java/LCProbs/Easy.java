package LCProbs;

import java.util.HashMap;
import java.util.Map;

public class Easy {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(twoSum(new int[]{2, 5, 5, 11},10)));

//        System.out.println(isAnagram("dhruba", "rubahd"));
//        System.out.println(buySellStock(new int[]{7,6,4,3,1}));
//        System.out.println(buySellStockUsingTwoLoops(new int[]{7,1,5,3,6,4}));
        System.out.println(buySellStockOptimized(new int[]{2,4,1}));

    }

    //2 sum
    static int[] twoSum(int[] nums, int target) {
        for(int i = 0 ; i< nums.length ; i++){
            for (int j = i+1; j< nums.length; j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    // wealthy
//    Input: accounts = [[1,5],[7,3],[3,5]]
//    Output: 10
    public int maximumWealth(int[][] accounts) {
        int maxSum = 0;
        for(int[] arr: accounts){
            int sum =0;
            for(int i : arr){
                sum+=i;
            }
            if(sum>maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }

    // valid anagram

    // using asccii not much understandable
//    public static boolean isAnagram(String s, String t) {
//        if(s.length() != t.length()) return false;
//        int[] count = new int[26];
//
//        for (int i = 0; i < s.length(); i++) {
//            count[s.charAt(i) -'a']++;
//            count[t.charAt(i) -'a']--;
//        }
//
//        for(int c:count){
//            if(c != 0) return false;
//        }
//
//        return true;
//    }

    // use hashmap

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)-1);
        }

        for(int c:map.values()){
            if(c != 0) return false;
        }

        return true;
    }



    // buy and sell stocks
    // 7 1 5 3 6 4
    public static int buySellStock(int[] arr){

        int[] firstMinArr = firstMin(arr);
        // this is only if it is a descending array
        if(firstMinArr[0] == -1) { return 0;}
        int lastMax = lastMax(arr,firstMinArr[1]);
        return lastMax - firstMinArr[0];

    }

    public static int lastMax(int[] arr,int pos){
        int max = arr[arr.length-1];
        for (int i = arr.length-1; i > pos; i--) {
            if(arr[i]>max)
                max = arr[i];
        }
        return max;
    }

    public static int[] firstMin(int[] arr){
        // iterate and find firstmin - if firstMin is last element & array is descending then return -1
        // return the first min
        // return a array of value and first min position
        int min = arr[0];
        int position = 0;
        for (int i = 0; i < arr.length; i++)
            if(arr[i]<min)
            {   
                position = i;
                min = (i == arr.length - 1) ? -1 : arr[i];
            }
        int[] returnArr = new int[2];
        returnArr[0] = min;
       returnArr[1] = position;
       return returnArr;
    }

    // buySellStock using 2 loops
    // O(n**2)
    public static int buySellStockUsingTwoLoops(int[] arr){

        int maxProfit = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if((arr[j] - arr[i]) > maxProfit)
                    maxProfit = arr[j] - arr[i];
            }
        }
        return maxProfit;

    }

    // striver solution

    public static int buySellStockOptimized(int[] arr){
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min)
                min = arr[i];
            if(arr[i] - min > maxProfit)
                maxProfit = arr[i] - min;
        }

        return maxProfit;
    }















}
