package ss3.bai_tap;

import java.util.Scanner;

public class gop_mang {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Enter the size of the first array
        System.out.print("Enter the size of the first array: ");
        int size1 = scanner.nextInt();

        // Enter the elements of the first array
        System.out.println("Enter the elements of the first array:");
        int[] array1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array1[i] = scanner.nextInt();
        }

        // Enter the size of the second array
        System.out.print("Enter the size of the second array: ");
        int size2 = scanner.nextInt();

        // Enter the elements of the second array
        System.out.println("Enter the elements of the second array:");
        int[] array2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array2[i] = scanner.nextInt();
        }

        // Create the merged array
        int size3 = size1 + size2;
        int[] array3 = new int[size3];

        // Copy the elements from the first array to the merged array
        for (int i = 0; i < size1; i++) {
            array3[i] = array1[i];
        }

        // Copy the elements from the second array to the merged array
        for (int i = 0; i < size2; i++) {
            array3[size1 + i] = array2[i];
        }

        // Display the merged array
        System.out.println("Merged array:");
        for (int i = 0; i < size3; i++) {
            System.out.print(array3[i] + " ");
        }
    }
}

