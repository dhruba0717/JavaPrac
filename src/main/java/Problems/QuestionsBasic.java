package Problems;

import java.util.*;

public class QuestionsBasic {

    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        System.out.println("Enter number");
//        System.out.println(isArmstrong(153));
//        System.out.println(getLength(567));

//        System.out.println(isPrime(83));
        //        System.out.println(checkPalindrome("madam"));
       // System.out.println(checkOccurence("sentence"));
//        System.out.println(isValid("()"));
//        System.out.println(permutationOfString("ABC"));
        System.out.println(reverseSentence("My Name is Srijani"));
    }

    public static String reverseSentence(String s){
        char[] arr = s.toCharArray();
        int left = 0;
        int right = s.length() -1;
        while(left<=right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }

    static List<String> permutationOfString(String s){
        List<String> result = new ArrayList<>();
        if(s==null || s.isEmpty()) return result;
        permute("",s,result);
        return result;
    }

    private static void permute(String prefix, String remaining, List<String> result) {
        if(remaining.isEmpty()){
            result.add(prefix);
            return;
        }


    }

    // write a function to tell if number is prime
    static boolean isPrime(int x){
        boolean b = false;
            if(x>=1){
                int c = 0;
                for(int i = 1; i<=x ; i++){

                    if(x%i == 0){
                        c++;
                    }
                }
                if(c==2){
                    b = true;
                }
            }
            return b;
    }

    // length of a number ex 153 - 3
    static int getLength(int x){
        int len = 0;
        while (x>=1){
            int ud = x%10;
            x = x/10;
            len++;
        }
        return len;
    }

    // Write a function to check if Armstrong num
    //a number that is equal to the sum of its own digits,
    // each raised to the power of the number of digits in the number
    // Ex 153 = 1^3 + 5^3 + 3^3
    static boolean isArmstrong (int x){
        int value = x;
        int sum = 0;
        int c = getLength(x);
        while(x>0){
            sum += Math.pow((x%10),c);
            x = x/10;
        }
        return sum == value;

    }

    public static boolean checkPalindrome(String s){
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length/2; i++){

            if (  arr[i] != arr[arr.length - i -1]){
                return false;
            }
        }

        return true;

    }

    public static HashMap<Character, Integer> checkOccurence(String s) {
        HashMap<Character, Integer> hashArr = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (hashArr.containsKey(arr[i])) {
                hashArr.put(arr[i], hashArr.get(arr[i]) + 1);
            } else {
                hashArr.put(arr[i], 1);
            }
        }
        return hashArr;
    }



    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            // if opening tags push into stack
            if(c == '(' || c =='[' || c == '{'){
                stack.push(c);
            }
            else {
                // if not opening tag --> stack should be empty
                if(stack.isEmpty()) return false;
                // else tag should have opening tag in the stack already
                char top = stack.pop();
                if(c == ')' && top != '(' ||
                        c == ']' && top != '[' ||
                        c == '}' && top != '{'){
                    return false;
                }
            }

        }
        // at the end stack should be empty if all matches
        return stack.isEmpty();
    }

    //  same using











}
