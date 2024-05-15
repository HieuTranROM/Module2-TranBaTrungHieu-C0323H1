package ss3.bai_tap;

import java.util.Scanner;

public class dem_so_lan_xuat_hien_ki_tu_trong_chuoi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the string from the user
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Input the character to count from the user
        System.out.print("Enter a character to count: ");
        char character = scanner.next().charAt(0);

        // Count the occurrences of the character in the string
        int count = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == character) {
                count++;
            }
        }

        // Display the count of occurrences
        System.out.println("The character '" + character + "' appears " + count + " times in the string.");

        scanner.close();
    }
}

