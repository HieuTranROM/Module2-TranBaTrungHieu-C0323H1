package ss1.baitap;

import java.util.Scanner;

public class doc_so_thanh_chu {
    private static final String[] UNITS = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen"
    };

    private static final String[] TENS = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer (up to 3 digits): ");
        int number = scanner.nextInt();

        if (number < 0 || number > 999) {
            System.out.println("Invalid number. Please enter a non-negative integer up to 3 digits.");
            return;
        }

        String words = convertToWords(number);
        System.out.println(words);
    }

    public static String convertToWords(int number) {
        if (number == 0) {
            return "zero";
        }

        if (number < 20) {
            return UNITS[number];
        }

        if (number < 100) {
            return TENS[number / 10] + " " + convertToWords(number % 10);
        }

        return UNITS[number / 100] + " hundred " + convertToWords(number % 100);
    }
}
