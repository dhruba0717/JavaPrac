package LCProbs;

import java.util.Arrays;

public class Easy {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 5, 5, 11},10)));
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
}
