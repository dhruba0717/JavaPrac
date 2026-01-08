package practicev3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class JavaPrac {


    public static void main(String[] args) {

//        System.out.println(validPalindromeSentence("A man, a plan, a canal: Panama"));
//        System.out.println(reverseStringWithoutReverse("Dhruba"));
//        System.out.println(palindromeNumber(12321));
        //Reverse an array without usig a new array
//        System.out.println(Arrays.toString(reverseArray(new int[]{3,5,7,1,2})));
        // contains duplicate
//        System.out.println(containsDuplicate(new int[]{3,5,7,1,2,7,3,3}));
        // countOccurence string
//        System.out.println(countOccurence("Dhruuaabajoyti"));
        //two sum
//        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 22)));
        System.out.println(buySellStock(new int[]{7, 1, 5, 3, 6, 4}));
    }
    private static int buySellStock(int[] arr){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i : arr) {
            int profit =0;
            if(i<minPrice)
                minPrice = i;
            profit = i -minPrice;
            if(profit>maxProfit)
                maxProfit = profit;
        }
        return maxProfit;
    }
    private static int[] twoSum(int[] arr,int target){
        HashMap<Integer,Integer> h = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if(h.containsKey(target-arr[i])){
                return new int[]{h.get(target-arr[i]),i};
            } else {
                h.put(arr[i],i);
            }


        }
        return new int[]{-1,-1};
    }

    private static HashMap<Character,Integer> countOccurence(String s) {
        HashMap<Character,Integer> ans = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            ans.put(s.charAt(i),ans.getOrDefault(s.charAt(i),0)+1);
        }
        return ans;
    }

    private static HashSet<Integer> containsDuplicate(int[] arr){
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> dups = new HashSet<>();

        for(int i:arr){
            if(!seen.add(i)){
                dups.add(i);
            }
        }
        return dups;


    }
    private static int[] reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length -1;
        while (start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    return arr;
    }
    private static boolean palindromeNumber(int i) {
        int temp = i;
        int n=0;
        while (i>0){
            n = n*10 + i%10;
            i = i/10;
        }
        return n == temp;
    }

    private static String reverseStringWithoutReverse(String s) {
        char[] c = s.toCharArray();
        int start = 0;
        int end = s.length() -1;
        while (start<=end){
            char temp = c[end];
            c[end] = c[start];
            c[start] = temp;
            start++;
            end--;
        }
        return new String(c);
    }

    private static boolean validPalindromeSentence(String s) {
        int start = 0;
        int end = s.length() -1;
        while (start<=end){
            char l = s.charAt(start);
            char r = s.charAt(end);

            if(!Character.isLetterOrDigit(l)){
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(r)){
                end--;
                continue;
            }
            if(Character.toLowerCase(l)!=Character.toLowerCase(r)) { return false;}
            start++;
            end--;
        }
        return true;
    }
}
