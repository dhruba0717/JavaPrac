package LCProbs;

import java.util.*;

public class ImpPracticeAgain {

    public static void main(String[] args) {
//                System.out.println(palindromeString("2ma4dd4am2")); DONE
//        System.out.println(reverseString("dhruba")); DONE
//        System.out.println(palindromeStringSentence("A man a plan a canal ,Panama")); DONE
//        System.out.println(checkPalindromeNumber(123321)); DONE
//        System.out.println(countOccurece("loveleetcode")); DONE
//        System.out.println(compressString("aaabbbccd")); *** DONE
//        System.out.println(findMissingNum(new int[]{0,1,2,3,4,6,7}));
//        System.out.println(Arrays.toString(moveZeroestoEnd(new int[]{0, 1, 0, 3, 12}))); DONE
//        System.out.println(reverseSentence("Dhruba love Spring Boot")); //"Boot Spring love Dhruba"
//        System.out.println(secondLargestElement(new int[]{10, 20, 4, 45, 99}));
//        System.out.println(removeDuplicateFromArray(new int[]{4, 5, 9, 4, 9, 8, 5}));
//        System.out.println(buySellStock(new int[]{7,1,5,3,6,4})); // 6-1 =5
//        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 22)));   //2, 7, 11, 15 target 22 -> [1,3]
    }

    public static int[] twoSum(int[] arr,int target){
        // map to store seen no and their index
        HashMap<Integer,Integer> h= new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if(h.containsKey(diff)){
                return new int[]{h.get(diff),i};
            } else {
                h.put(arr[i],i);
            }
        }
        return new int[]{-1,-1};
    }

    public static int buySellStock(int[] arr){
        int lowestPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price :arr) {
            if(price<lowestPrice) lowestPrice = price;
            if(price - lowestPrice>maxProfit) maxProfit = price - lowestPrice;
        }
        return maxProfit;
    }

    private static int[] removeDuplicateFromArray(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : arr) {
            if (!seen.contains(num)) {  // first time seeing this number
                seen.add(num);
                result.add(num);
            }
        }

        // convert ArrayList back to array
        return result.stream().mapToInt(i -> i).toArray();
    }

    private static int secondLargestElement(int[] ints) {

        int largest = Integer.MIN_VALUE;
        for (int i:ints){
            if(i>largest){
                largest =i;
            }
        }
        int ans =Integer.MIN_VALUE;
        for (int i:ints){
            if(i> ans && i<largest){
                ans =i;
            }
        }
        return ans;


    }

    private static StringBuilder reverseSentence(String s) {
        String[] words = s.trim().split("\\s+"); // split by spaces
        System.out.println(Arrays.toString(words));
        StringBuilder result = new StringBuilder();
        for (int i = words.length -1; i >=0 ; i--) {
            result.append(words[i]);
            if(i!=0)result.append(" ");
        }
        return result;
    }

    private static int[] moveZeroestoEnd(int[] arr){
        int ref=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                arr[ref] = arr[i];
                ref++;
            }
        }

        // fill remaining with 0
        while (ref<arr.length){
            arr[ref] = 0;
            ref++;
        }
        return arr;
    }

    private static int findMissingNum(int[] ints) {

        // find max in ints
        int max= Integer.MIN_VALUE;
        int sum =0;
        for(int i:ints){
            if(i>max) max = i;
            sum+=i;
        }
        return max*(max+1)/2 -sum;

    }

//    public static StringBuilder compressString(String c){
//        StringBuilder s = new StringBuilder();
//        HashMap<Character,Integer> h = new HashMap<>();
//        for(char c1: c.toCharArray()){
//            h.put(c1,h.getOrDefault(c1,0)+1);
//        }
//        for(Map.Entry<Character,Integer> e: h.entrySet()){
//            s.append(e.getKey());
//            s.append(e.getValue());
//        }
//        return s;
//    }

        public static StringBuilder compressString(String c){
        StringBuilder s = new StringBuilder();
        // using 2 pointer
            int count = 1; // count of a letter
            for (int i = 1; i < c.length(); i++) {
                if(c.charAt(i) == c.charAt(i-1)){
                    count++;
                } else {
                    // new character seen
                    // add result in s and reset count
                    s.append(c.charAt(i-1)).append(count);
                    count =1;
                }
            }
            // Append the last group (important!)
            s.append(c.charAt(c.length() - 1)).append(count);
            return s;
    }

    public static HashMap<Character,Integer> countOccurece(String s){
        HashMap<Character,Integer> h = new HashMap<>();
        for(char c: s.toCharArray()){
            h.put(c,h.getOrDefault(c,0)+1);
        }
        return h;
    }

    public static boolean checkPalindromeNumber(int n){
        int ans = 0;
        int temp = n;
        while (n>0){
            ans = ans*10 + n%10;
            n = n/10;
        }
        return ans==temp;
    }

//    public static StringBuilder reverseStringBuilder(String s){
//        StringBuilder ans = new StringBuilder();
//        for (int i = s.length() -1; i >= 0 ; i--) {
//            ans.append(s.charAt(i));
//        }
//        return ans;
//    }

    public static String reverseString(String s){
        char[] c = s.toCharArray();
        int start = 0;
        int end = c.length -1;

        while (start < end){
            // if element at start == element at end then swap
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
        return new String(c);
    }

    public static boolean palindromeString(String s){
        int left = 0;
        int right =s.length() -1;

        while (left<right){
            char lc = s.charAt(left);
            char rc = s.charAt(right);

            if(lc != rc){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

    public static boolean palindromeStringSentence(String s){
        int left = 0;
        int right =s.length() -1;

        while (left<right){
            char lc = s.charAt(left);
            char rc = s.charAt(right);

            if(!Character.isLetter(lc)){
                left++;
                continue;
            } else if (!Character.isLetter(rc)) {
                right--;
                continue;
            }
            if(Character.toLowerCase(lc) != Character.toLowerCase(rc)){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }


}
