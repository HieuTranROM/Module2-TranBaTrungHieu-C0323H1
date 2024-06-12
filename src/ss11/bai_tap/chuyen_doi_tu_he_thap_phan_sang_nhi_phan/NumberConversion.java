package ss11.bai_tap.chuyen_doi_tu_he_thap_phan_sang_nhi_phan;

import java.util.Stack;

import java.util.Scanner;

public class NumberConversion {
    public static String decimalToBinary(int decimal) {
        Stack<Integer> stack = new Stack<>();

        while (decimal > 0) {
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal /= 2;
        }

        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }

    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        int power = 0;

        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }

        return decimal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so nguyen duong he thap phan: ");
        int decimal = scanner.nextInt();

        String binary = decimalToBinary(decimal);
        System.out.println("He nhi phan: " + binary);

        System.out.print("Nhap chuoi nhi phan: ");
        String inputBinary = scanner.next();

        int convertedDecimal = binaryToDecimal(inputBinary);
        System.out.println("He thap phan: " + convertedDecimal);

        scanner.close();
    }
}

