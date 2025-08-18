package Arrays.Searching;

public class BinarySearchProblems {

    public static void main(String[] args) {
        int[] arr = {2,4,13,15,19,45,64,89};
        char[] arrChar = {'e','e','e','k','q','q','q','v','v','y'};
//        System.out.println(ceil(arr,17));
//        System.out.println(floor(arr, 17));
//        System.out.println(nextGreatestLetter(arrChar,'q'));
//        System.out.println(firstOccurence(new int[]{5,6,7,7,7,8,8,10},7));
//        System.out.println(lastOccurence(new int[]{5,6,7,7,7,8,8,10},8));
//        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
////        System.out.println(binarySearchInfiniteArray(new int[]{5, 5, 6, 7, 7},7));
        System.out.println(peakIndexInMountainArray(new int[]{3,5,3,2,0}));
    }

    // write a fucntion to find the celing of a number in an array
    //  suppose 17 target - the celing is 19 which is the smallest number just equal and bigger than 17
    static int ceil(int[] arr , int target){
        int startIndex = 0;
        int endIndex = arr.length -1;

        while (startIndex <= endIndex){
            int mid = startIndex + (endIndex - startIndex) / 2 ;
            if(target< arr[mid]){
                endIndex = mid -1;
            } else if (target > arr[mid]) {
                startIndex = mid + 1;
            }
            else
                return arr[mid];
        }
        if(startIndex > arr.length -1){
            // element has no ceil
            return -1;
        }else {
            return arr[startIndex];
        }
    }


    static int floor(int[] arr , int target){
        int startIndex = 0;
        int endIndex = arr.length -1;

        while (startIndex <= endIndex){
            int mid = startIndex + (endIndex - startIndex) / 2 ;
            if(target< arr[mid]){
                endIndex = mid -1;
            } else if (target > arr[mid]) {
                startIndex = mid + 1;
            }
            else
                return arr[mid];
        }
        if(endIndex< 0){
            // element has no ceil
            return -1;
        }else {
            return arr[endIndex];
        }

    }


//      744. Find Smallest Letter Greater Than Target
//    https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length -1;
        if(target >= letters[letters.length -1]){
            return letters[0];
        }
        else{
            while(start<=end){
                int mid = start + (end - start)/2;
                if(letters[mid]>target){
                    end = mid -1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return letters[start% letters.length];
    }


//    34. Find First and Last Position of Element in Sorted Array
    // brute fore {5, 7, 7, 8, 8, 10} - > 0(n)
    static int[] searchRangeBrute(int[] nums, int target) {
        int start = -1;
        int end = -1;
        if(nums.length == 1 && nums[0] == target){
            start = end = 0;
        }
        else{
            for(int i= 0; i<=nums.length -1 ; i++){
                if(nums[i]== target && start== -1){
                    start = i;
                } else if (nums[i] == target) {
                    end = i;
                }
            }
        }

        if(start != -1 && end == -1){
            end = start;
        }

        return  new int[]{start,end};
    }

    // to do this problem first do binary search to find first occurence of target
    static int firstOccurence(int[] arr , int target){
        int f = -1;   // if no occurence
        int s = 0;
        int e = arr.length -1;
        while (s<=e){
            int m = s + (e - s)/2;
            if(target< arr[m]){
                e = m-1;
            } else if (target > arr[m]) {
                s = m + 1;
            } else {
                if( f == -1){
                    // if no change made
                    f = m;
                    e = m -1;
                } else if ( m < f) {
                    f = m;
                    e = m - 1;
                }
            }
        }
        return f;
    }

    static int lastOccurence(int[] arr , int target){
        int f = -1;   // if no occurence
        int s = 0;
        int e = arr.length -1;
        while (s<=e){
            int m = s + (e - s)/2;
            if(target< arr[m]){
                e = m-1;
            } else if (target > arr[m]) {
                s = m + 1;
            } else {
                if( f == -1){
                    f = m;
                    s = m +1;
                } else if ( m > f) {
                    f = m;
                    s = m +1;
                }
            }
        }
        return f;
    }

    static int[] searchRange(int[] nums, int target) {
        int f = -1;
        int l = -1;
        int s = 0;
        int e = nums.length -1;
        while (s<=e){
            int m = s + (e - s)/2;
            if(target< nums[m]){
                e = m-1;
            } else if (target > nums[m]) {
                s = m + 1;
            } else {
                if( f == -1){
                    f = m;
                    e = m -1;
                } else if ( m < f) {
                    f = m;
                    e = m - 1;
                }
            }
        }

        s = 0;
        e = nums.length -1;
        while (s<=e){
            int m = s + (e - s)/2;
            if(target< nums[m]){
                e = m-1;
            } else if (target > nums[m]) {
                s = m + 1;
            } else {
                if( l == -1){
                    l = m;
                    s = m +1;
                } else if ( m > f) {
                    l = m;
                    s = m +1;
                }
            }
        }
        return new int[]{f,l};
    }


    // infinity array - arr.lenght not tp be used - bottom up approach
    // func to get start and end
    // {2,3,5,7,11,15,23,46,64}
    static int binarySearchInfiniteArray(int[] arr, int target){
        // start with first 2 element chunk and increase the size of chunk doubling
        int start = 0;
        int end = 1;
        // double the chunk until element is inside chunk - target > arr[end] then element not inside chunk
        while(target > arr[end]){
            int newStart = end + 1;
            end = end + (end -start +1)*2;
            start = newStart;
        }
        return binarySearch(arr, target,start,end);

    }

    static int binarySearch(int[] arr , int target , int startIndex , int endIndex){
        while (startIndex <= endIndex){
            int mid = startIndex + (endIndex - startIndex) / 2 ;
            if(target< arr[mid]){
                endIndex = mid -1;
            } else if (target > arr[mid]) {
                startIndex = mid + 1;
            }
            else
                return mid;
        }
        return -1;

    }


    // mountain array - peak find - important
    static int peakIndexInMountainArray(int[] arr) {
        int s= 0;
        int e = arr.length -1;
        while(s<e){
            int m = s + (e-s)/2;
            if(arr[m] > arr[m+1]){
                //decr array
                e = m;
            } else {
                // incr array
                s = m+1;
            }
        }
        return s;
    }

    // 1095 https://leetcode.com/problems/find-in-mountain-array/
//    static int findInMountainArray(int target, MountainArray mountainArr) {
//
//    }
































}
