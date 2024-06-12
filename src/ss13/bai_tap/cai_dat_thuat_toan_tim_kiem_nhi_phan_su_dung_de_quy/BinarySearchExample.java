package ss13.bai_tap.cai_dat_thuat_toan_tim_kiem_nhi_phan_su_dung_de_quy;

import java.util.Arrays;

public class BinarySearchExample {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 7}; // Step 1: Initialize the array

        Arrays.sort(array); // Step 2: Sort the array

        int value = 7; // The value to search for

        int index = binarySearch(array, 0, array.length - 1, value); // Step 3: Perform the binary search

        if (index != -1) {
            System.out.println("The value " + value + " is found at index " + index);
        } else {
            System.out.println("The value " + value + " is not found in the array");
        }
    }

    private static int binarySearch(int[] array, int left, int right, int value) {
        if (left > right) { // Step 8: Check if left > right
            return -1; // Value not found
        }

        int middle = (left + right) / 2; // Step 4: Calculate middle index

        if (array[middle] == value) { // Step 5: Check if middle element is equal to value
            return middle; // Value found
        } else if (value > array[middle]) { // Step 6: Check if value is greater than middle element
            return binarySearch(array, middle + 1, right, value); // Search in the right half
        } else { // Step 7: value < array[middle], search in the left half
            return binarySearch(array, left, middle - 1, value);
        }
    }
}

