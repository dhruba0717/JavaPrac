package LCProbs;

import java.util.Arrays;
import java.util.HashSet;

public class Med {

    public static void main(String[] args) {
//        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
        int[] nums = {-1};
        rotate(nums,2);
//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

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


    // Maximum subarray
    // brute force -> consider all subarrays -> check max sum
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i; j < nums.length; j++) {
                if(i!=j) {
                    sum += nums[j];
                }
                if(sum>max){
                    max = sum;
                }
            }
        }
        return max;
    }

    // optimized -> “At each index, decide whether to extend the previous
    // subarray or start a new subarray from the current element.”
    public static int maxSubArrayKadane(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(nums[i],sum+nums[i]);
            if(sum>max)
                max = sum;
        }
        return max;
    }

    // same problem implementation return the subarray instead of the sum
//    You can summarize Kadane in one line in your mind:
//            “At each step, either extend the current subarray or start a new subarray here,
//    then check if it’s the best.”
    public static int[] maxSubArrayKadaneReturnSubarray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int startTemp = 0;   // potential start of a new subarray
        int start = 0;       // start index of max subarray
        int end = 0;         // end index of max subarray

        for (int i = 0; i < nums.length; i++) {
            if (currentSum + nums[i] < nums[i]) {
                // start new subarray at i
                currentSum = nums[i];
                startTemp = i;
            } else {
                // extend current subarray
                currentSum += nums[i];
            }

            // update maxSum and indices if needed
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = startTemp;
                end = i;
            }
        }

        // extract the subarray
        return Arrays.copyOfRange(nums, start, end + 1);
    }







}
