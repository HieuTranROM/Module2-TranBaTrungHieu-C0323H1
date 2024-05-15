package ss3.bai_tap;

import java.util.Scanner;

public class xoa_phan_tu_khoi_mang {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Enter the size of the array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Initialize the array
        int[] array = new int[size];

        // Enter the elements of the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        // Enter the element to remove
        System.out.print("Enter the element to remove: ");
        int elementToRemove = scanner.nextInt();

        // Find the position of the element to remove in the array
        int position = -1;
        for (int i = 0; i < size; i++) {
            if (array[i] == elementToRemove) {
                position = i;
                break;
            }
        }

        // Remove the element if found
        if (position != -1) {
            // Shift the elements after the position to the left
            for (int i = position; i < size - 1; i++) {
                array[i] = array[i + 1];
            }

            // Decrease the size of the array by 1
            size--;

            System.out.println("Element " + elementToRemove + " has been removed from the array.");
        } else {
            System.out.println("Element " + elementToRemove + " does not exist in the array.");
        }

        // Display the array after removing the element
        System.out.println("Array after removing the element:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
            }
        }
    }



