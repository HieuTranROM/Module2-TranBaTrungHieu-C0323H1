package ss3.bai_tap;

import java.util.Scanner;

public class them_phan_tu_vao_mang {

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

        // Enter the value to insert
        System.out.print("Enter the value to insert: ");
        int valueToInsert = scanner.nextInt();

        // Enter the position to insert
        System.out.print("Enter the position to insert (0-based index): ");
        int positionToInsert = scanner.nextInt();

        // Check if the position is valid
        if (positionToInsert < 0 || positionToInsert > size) {
            System.out.println("Invalid position! Position should be between 0 and " + size);
            return;
        }

        // Increase the size of the array by 1
        size++;
        int[] newArray = new int[size];

        // Copy the elements to the new array
        for (int i = 0, j = 0; i < size; i++, j++) {
            if (i == positionToInsert) {
                newArray[i] = valueToInsert;
                j--;
            } else {
                newArray[i] = array[j];
            }
        }

        // Update the original array with the new array
        array = newArray;

        System.out.println("Value " + valueToInsert + " has been inserted at position " + positionToInsert);

        // Display the updated array
        System.out.println("Updated array:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

