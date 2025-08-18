package Arrays.Searching;

public class OrderAgnosticBinarySearch
{
    // we know for binary search sorted array but how do we know ascendin or descending
    // for ascending start < end
    // for descending start > end
    // all rules are same except search in right and left
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,8,45,76,789,3453};
        int[] arrDesc = {546,345,76,32,21,7,3,1};
        int target = 76;
        // find mid element ? start (0) + end(6) / 2 = 3
        // arr[3] 45  --- lets say we search for 76
        // is mid element < target --- search the right side
        // is mid element > target --- search the left side
        // is mid element = target --- ans
        // so new array is now 76,789,3453 again do same
        // mid element 4+6 / 2 = 5 arr[5] = 789 so find in left side and move on
        System.out.println(binarySearchOrderAgnostic(arr,1));

    }

    private static int binarySearchOrderAgnostic(int[] arr, int i) {
        int start = 0;
        int end = arr.length - 1;
        if (arr[start] < arr[end]) {
            // for ascending
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] > i) {
                    end = mid - 1;
                } else if (arr[mid] < i) {
                    start = mid + 1;
                } else {
                    return mid;
                }

            }
        } else {
            // for descending
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] > i) {
                    start = mid + 1;
                } else if (arr[mid] < i) {
                    end = mid - 1;
                } else {
                    return mid;
                }

            }
        }
        return -1;
    }




}
