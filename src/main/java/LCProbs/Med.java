package LCProbs;

import java.util.Arrays;
import java.util.HashSet;

public class Med {

    public static void main(String[] args) {
//        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
        int[] nums = {-1};
        rotate(nums,2);
//        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }

    public static int findDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.contains(num)) {
                hashSet.add(num);
            } else {
                return num;
            }
        }
        return -1;
        }

        // 189. Rotate Array

    public static void rotate(int[] nums, int k) {
        if(nums.length != 1){
            int[] rotatedNums = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if(i+k < nums.length)
                    rotatedNums[i+k] = nums[i];
                else
                    rotatedNums[(i+k) - nums.length] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = rotatedNums[i];
            }
        }
    }

    //238. Product of Array Except Self
//    Input: nums = [1,2,3,4]
//    Output: [24,12,8,6]

    // BRUTE FORCE
//    public static int[] productExceptSelf(int[] nums) {
//        int[] numsR = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int prod = 1;
//            for (int j = 0; j < nums.length; j++) {
//                if(j != i){
//                    prod*= nums[j];
//                }
//            }
//            numsR[i] = prod;
//        }
//        return numsR;
//    }

    // OPTIMIZED - USE LEFT TO RIGHT APPROACH
    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        int[] right = new int[nums.length];
        right[nums.length -1] = 1;
        for (int i = nums.length -2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }









}
