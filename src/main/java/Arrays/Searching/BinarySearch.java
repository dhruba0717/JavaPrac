package Arrays.Searching;

public class BinarySearch {

    // lets assume a sorted array
    public static void main(String[] args) {
            int[] arr = {2,5,8,45,76,789,3453};
            int target = 76;
            // find mid element ? start (0) + end(6) / 2 = 3
            // arr[3] 45  --- lets say we search for 76
            // is mid element < target --- search the right side
            // is mid element > target --- search the left side
            // is mid element = target --- ans
            // so new array is now 76,789,3453 again do same
        // mid element 4+6 / 2 = 5 arr[5] = 789 so find in left side and move on
//        System.out.println(binarySearch(arr,76));
//        System.out.println(binaryRevise(arr, 555));
        System.out.println(orderAgnosticbinaryRevise(new int[]{456, 320, 32, 16, 12, 7, 4, 1},7));

    }

    // Binary Search Revise - works only for sorted array

    public static int binaryRevise(int[] arr, int x){
        int start = 0;
        int end = arr.length -1;
        int mid;
        while( end >= start){
            mid  = start + (end - start)/2;
            if(arr[mid] == x){
                return mid;
            } else if (arr[mid] > x) {
                end = mid -1;
            } else {
                start = mid +1;
            }
        }

        return -1;
    }

    public static int orderAgnosticbinaryRevise(int[] arr, int x){
        int start = 0;
        int end = arr.length -1;
        int mid;

        if(arr[0] < arr[arr.length -1]){  // ascending
            while( end >= start){
                mid  = start + (end - start)/2;
                if(arr[mid] == x){
                    return mid;
                } else if (arr[mid] > x) {
                    end = mid -1;
                } else {
                    start = mid +1;
                }
            }
        }
        else {
            while( end >= start){
                mid  = start + (end - start)/2;
                if(arr[mid] == x){
                    return mid;
                } else if (arr[mid] > x) {
                    start = mid +1;
                } else {
                    end = mid -1;
                }
            }
        }


        return -1;
    }
















    //return the index if target is found else -1
    static int binarySearch(int[] arr , int target){
        int startIndex = 0;
        int endIndex = arr.length -1;

        while (startIndex <= endIndex){
//            int mid = (startIndex + endIndex) / 2;  // if index too big then integer sizewill exceed hence exception
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




    }
