package LCProbs;

import java.util.*;

public class Easy {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(twoSum(new int[]{2, 5, 5, 11},10)));

//        System.out.println(isAnagram("dhruba", "rubahd"));
//        System.out.println(buySellStock(new int[]{7,6,4,3,1}));
//        System.out.println(buySellStockUsingTwoLoops(new int[]{7,1,5,3,6,4}));
//        System.out.println(buySellStockOptimized(new int[]{2,4,1}));
//        System.out.println(firstUniqCharOptimized("aabb"));
//        System.out.println(lengthInt(12311));
//        System.out.println(isPalindrome(123321));
//        System.out.println(isPalindromeString("A man, a plan, a canal: Panama"));
//        System.out.println(search(new int[]{-1,0,3,5,9,12},9));
        System.out.println(mergeAndSort(new int[]{4,1,3,7,5,12},new int[]{11,3,7,22,43,17}));
    }

    private static List<Integer> mergeAndSort(int[] ints, int[] ints1) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i: ints){
            ans.add(i);
        }
        for(int i: ints1){
            ans.add(i);
        }
        return ans.stream().sorted().toList();

    }

    //125. Valid Palindrome
    //    Input: s = "A man, a plan, a canal: Panama"
    //  Output: true
    //  Explanation: "amanaplanacanalpanama" is a palindrome.
    public static boolean isPalindromeString(String s) {
        char[] ch = s.toCharArray();
        ArrayList<Character> newCh = new ArrayList<>();
        // create the raw array
        for(char c: ch){
            if(c >= 'a' && c<= 'z'){
                newCh.add(c);
            } else if (c >= 'A' && c<= 'Z') {
                newCh.add(Character.toLowerCase(c));
            }
        }
        boolean isPal = true;
        // check if the raw array is palindrome
        for (int i = 0; i < newCh.size(); i++) {
            if(newCh.get(i)!=newCh.get(newCh.size()-1-i)){
                isPal = false;
                break;
            }
        }
        return isPal;

    }

    public static boolean isPalindromeOptimized(String s){
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            // Skip non-alphanumeric characters
            if (!Character.isLetterOrDigit(l)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(r)) {
                right--;
                continue;
            }

            // Compare lowercase
            if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // code to find length of an integer
    public static int lengthInt(int x){
        if (x == 0) return 1;  // handle zero
        x = Math.abs(x);        // handle negative numbers
        int size = 0;
        while(x>0){
            x = x/10;
            size++;
        }
        return size;
    }

    // palindrome 9. LC
    public static boolean isPalindrome(int x) {
        // Negative numbers or numbers ending with 0 (except 0 itself) are not palindromes
        if(x<0 || (x!=0 && x%10 == 0))
            return false;

        int reversedHalf = 0;
        while(x>reversedHalf){
            reversedHalf = reversedHalf*10 + x%10;
            x = x/10;
            System.out.println("x ->"+x+"revX->"+reversedHalf);
        }

        return x==reversedHalf || x==reversedHalf /10;


    }

    // brute force - On2
    public static int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            boolean unique = true;
            for (int j = 0; j < s.length(); j++) {
                if(i!=j){
                    if(s.charAt(i)==s.charAt(j)){
                        unique = false;
                        break;
                    }
                }
            }
            if(unique)
                return i;
        }
        return -1;
    }

    // hashmap approach -> LinkedHashMap maintains order
    public static int firstUniqCharOptimized(String s) {
        LinkedHashMap<Character, Integer> h = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            h.put(ch, h.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : h.entrySet()) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }

        return -1;
    }



    //2 sum -> Brute Force o(n2)
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0 ; i< nums.length ; i++){
            for (int j = i+1; j< nums.length; j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    // As we iterate through the array, we check if the complement (target - nums[i]) has already been seen.
    //If yes, we immediately return the indices.
    //If not, we store the current number and its index in a HashMap for future lookup.

    public static int[] twoSumHashMapApproach(int[] nums, int target) {
        // create a hashmap < Value in array , Index>
        HashMap<Integer, Integer> look = new HashMap<>();

        // look at the array
        for (int i = 0; i < nums.length; i++) {
            // if value in hashmap return
            if(look.containsKey(target - nums[i])){
                return new int[]{i,look.get(target - nums[i])};
            }
            // else store value in hashmap
            else {
                look.put(nums[i], i);
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

    // Think about what you’re actually tracking.
    //You don’t really need to check every pair of days. You only need two things:
    //The lowest price you’ve seen so far.
    //The maximum profit you could get if you sold today.
    //As you move forward in the array, at each price:
    //You can calculate how much profit you’d make if you bought at the lowest price so far and sold today.
    //Then update the maximum profit if this one is better.

        public int buySellStockOptimized(int[] prices) {
            int maxProfit = 0;
            int lowestPrice = Integer.MAX_VALUE;
            for(int i= 0;i<prices.length;i++){
                if(prices[i]<lowestPrice){
                    lowestPrice = prices[i];
                }
                // if i sell it today
                int maxProfitToday = prices[i] - lowestPrice;
                if(maxProfitToday>maxProfit){
                    maxProfit = maxProfitToday;
                }

            }
            return maxProfit;
        }

        // binary search LC
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target > nums[mid]){
                start = mid+1;
            } else if(target < nums[mid]){
                end = mid-1;
            } else{
                return mid;
            }
        }
        return -1;
    }




















}
