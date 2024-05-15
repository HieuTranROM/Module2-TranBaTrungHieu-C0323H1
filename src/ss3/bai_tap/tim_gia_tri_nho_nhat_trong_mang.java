package ss3.bai_tap;

import java.util.Scanner;

public class tim_gia_tri_nho_nhat_trong_mang {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size from the user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        // Input array values from the user
        System.out.println("Enter the values of the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = scanner.nextInt();
        }

        // Find the minimum value in the array
        int minValue = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }

        // Display the minimum value
        System.out.println("The minimum value in the array is: " + minValue);

        scanner.close();
    }
}


