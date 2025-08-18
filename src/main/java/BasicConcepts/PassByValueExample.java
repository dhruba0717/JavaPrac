package BasicConcepts;

import java.util.Arrays;

public class PassByValueExample {

    public static void main(String[] args) {
        String name = "Dhruba";
        changeName(name);
        System.out.println(name); // Output: Dhruba

        int[] nums = {3, 4, 5, 6, 7};
        changeArray(nums);
        System.out.println(Arrays.toString(nums)); // Output: [22, 4, 5, 6, 7]
    }

    // Strings are immutable in Java, and Java is pass-by-value.
    // When changeName(name) is called, the value (reference to "Dhruba") is passed,
    // but inside the method, 'naam' is just a copy of that reference.
    // Reassigning 'naam' to point to "Srijani" does NOT affect 'name' in main().
    
    static void changeName(String naam) {
        naam = "Srijani"; // Only 'naam' now points to "Srijani", 'name' still points to "Dhruba"
    }

    // Arrays are objects in Java (mutable), and their reference is also passed by value.
    // When changeArray(nums) is called, the reference to the array is copied and passed.
    // But both the original and the copied reference point to the same array in memory.
    // So modifying the array via the copied reference (arr[0] = 22) affects the original array.

    static void changeArray(int[] arr) {
        arr[0] = 22; // This changes the actual array in memory
    }
}