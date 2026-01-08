package LCProbs;

import java.util.*;

public class ImportantProblems {

    public static void main(String[] args) {
//        System.out.println(palindromeString("hellh"));
//        System.out.println(reverseStringBuilder("dhruba"));
//        System.out.println(palindromeStringSentence("A man a plan a canal ,Panama"));
//        System.out.println(checkPalindromeNumber(123213));
//        System.out.println(countOccurece("loveleetcode"));
//        System.out.println(compressString("aaabbbccd"));
//        System.out.println(findMissingNum(new int[]{1,2,3,4,6,7}));
//        System.out.println(Arrays.toString(moveZeroestoEnd(new int[]{0, 1, 0, 3, 12})));
        System.out.println(containsDuplicate(new int[]{2, 3, 4, 4, 5, 8, 8, 9}));
    }

    private static HashSet<Integer> containsDuplicate(int[] ints) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> dups = new HashSet<>();
        for(int i: ints){
            if(!seen.add(i)){  // seen.add adds if not present else returns false
                dups.add(i);
            }
        }
        return dups;
    }

    public static boolean checkPalindromeNumber(int n){
        if(n<0){
            return false;  // negative always palindrome
        }
        int m = 0;
        int nTemp = n;
        while(n>0){

            m = m*10 + n%10;
            n = n/10;

        }

        if(m ==nTemp){
            return true;
        }
        return false;

    }
    public static boolean palindromeString(String name){
        int l = 0;
        int r = name.length() -1;

        while(l<=r){

            char left = name.charAt(l);
            char right = name.charAt(r);

            if(left == right){
                l++;
                r--;
            }
            else{
                return false;
            }

        }
        return true;
    }

    public static StringBuilder reverseStringBuilder(String name){

        StringBuilder s = new StringBuilder();
        for(int i = name.length() -1; i >= 0; i--){
            s.append(name.charAt(i));
        }
        return s;
    }



    public static boolean palindromeStringSentence(String name){
        int l = 0;
        int r = name.length() -1;

        while(l<=r){

            if(!Character.isLetter(name.charAt(l))){    // is letter to check alpha isDigit num isLetterOrDigit
                l++;
                continue;   // to ensure we break loop and next else also checked
            }
            else if(!Character.isLetter(name.charAt(r))){
                r--;
                continue;
            }

            char left = name.charAt(l);
            char right = name.charAt(r);


            if(Character.toLowerCase(left) == Character.toLowerCase(right)){   // case insenstive
                l++;
                r--;
            }
            else{
                return false;
            }

        }
        return true;
    }

    public static HashMap<Character, Integer> countOccurece(String s){

        HashMap<Character, Integer> m = new HashMap<>();

        for(int i = 0; i < s.length() ; i++){

            m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0) +1);

        }

        return m;


    }

    public static StringBuilder compressString(String s){
        // aaaabbbcaa a4b3c1a2
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == c){
                count++;
            }
            // if character change
            else {
                sb.append(c);
                sb.append(count);
                c = s.charAt(i);
                count = 1;
            }
        }
        // for last character if it comes only 1 time
        sb.append(c);
        sb.append(count);
        return sb;
    }

    public int missingNumber(int[] nums) {
        int maxArray = Integer.MIN_VALUE;
        int sumArray = 0;
        for(int i: nums){
            if(i>maxArray){
                maxArray = i;
            }
            sumArray += i;
        }

        int maxExpected = (maxArray*(maxArray+1))/2;
        return maxExpected - sumArray;
    }

//    one pointer i traverse array
//    another pointer j keeps the place where need to shift
//    i=0 j=0 - 0, 1, 0, 3, 12
//    i=1 j=0 - 1, 1, 0, 3, 12
//    i=2 j=1 - 1, 3, 0, 3, 12
//    i=3 j=2 - 1, 3, 3, 3, 12
//    i=4 j=3 - 1, 3, 12,3, 12


    public static int[] moveZeroestoEnd(int[] arr){
        int j =0;
        // i traverses loop
        // if i!= 0 , then places it in j position and j++
        for(int i: arr){
            if(i != 0){
                arr[j] = i;
                j++;
            }
        }

        // uptil this placing is done
        // from j = 3 to end of array - change it to 0

        for(int i= j; i<arr.length ; i++){
            arr[i] = 0;
        }
        return arr;

    }

    public static boolean validParanthesis(String s){

        Stack<Character> stack = new Stack<>();
        for(int i =0;i < s.length(); i++){
            // if starting braces then insert into stack
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.isEmpty()) {
                return false; // nothing to match with
            }
            // if not then see whats popped from stack
            char out = (char) stack.pop();
            if ((out == '(' && s.charAt(i) != ')') ||
                    (out == '[' && s.charAt(i) != ']') ||
                    (out == '{' && s.charAt(i) != '}')) {
                    return false;
                }
            }
            // finally the stack should be empty

        return stack.isEmpty();

    }

    // reverse array without using new array

    public static int[] reverseArray(int[] arr){
        int l = 0;
        int r = arr.length -1;

        while (l<r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return arr;

    }

    // anagram the same characters in the same frequency

    public static boolean isAnagram(String s1, String s2){
        HashMap<Character , Integer> h1 = new HashMap<>();
        HashMap<Character , Integer> h2 = new HashMap<>();

        if(s1.length() != s2.length()) return false;

        // frequency map of s1 created
        for (int i = 0; i < s1.length(); i++) {
            h1.put(s1.charAt(i),h1.getOrDefault(s1.charAt(i),0)+1);
        }

        // frequency map of s1 created
        for (int i = 0; i < s2.length(); i++) {
            h2.put(s2.charAt(i),h2.getOrDefault(s2.charAt(i),0)+1);
        }

        return h1.equals(h2);

    }

    // find duplicate
//    Problem Statement:
//You are given an array of integers nums containing n + 1 integers, where each integer is between 1 and n (inclusive).
//There is exactly one number that appears more than once — find that duplicate number.
//    Input: nums = [1, 3, 4, 2, 2]
//Output: 2
    public static int findDuplicate(int[] arr){
        HashMap<Integer, Integer> h = new HashMap<>();

        for(int i : arr){
            h.put(i,h.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer, Integer> e: h.entrySet()){
            if(e.getValue()>0) return e.getKey();
        }
    return -1;

    }


}
