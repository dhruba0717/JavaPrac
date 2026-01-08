package LCProbs;

import java.util.Arrays;
import java.util.HashMap;

public class SlidingWindowTwoPointerDemo {

    public static void main(String[] args) {

//        System.out.println((maxPointsFromCardGames(new int[]{6,2,3,4,7,2,1,7,1},4)));
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));



    }

    // 1. maximum points to obtain from cards
    public static int maxPointsFromCardGames(int[] arr , int k){

        int maxSum = 0;
        int leftSum = 0;
        int rightSum =0;
        for (int i = 0; i < k; i++) {
            leftSum += arr[i];
            maxSum = leftSum;
        }

        int rightIndex = arr.length -1;
        for (int i = k-1; i >=0 ; i--) {
            leftSum -= arr[i];
            rightSum += arr[rightIndex];
            rightIndex--;

            maxSum = Math.max(maxSum,leftSum+rightSum);
        }

        return maxSum;
    }

    public static int lengthOfLongestSubstring(String s) {
        int l =0;
        int r =0;
        HashMap<Character, Integer> hash = new HashMap<>();
        int mLen = 0;
        while (r<s.length()){
            if(!hash.containsKey(s.charAt(r))) {
                hash.put(s.charAt(r), r);
                mLen = Math.max(mLen, r - l + 1);
                r++;
            }
            else {
                l = Math.max(l, hash.get(s.charAt(r)) + 1);
                hash.put(s.charAt(r), r);        // if exist replace
                mLen = Math.max(mLen, r - l + 1);
                r++;
            }
        }

    return mLen;
    }













}
