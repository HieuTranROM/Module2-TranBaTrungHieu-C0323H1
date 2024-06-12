package ss11.bai_tap.dao_nguoc_phan_tu_trong_mang_so_nguyen;

import java.util.Scanner;
import java.util.Stack;

public class DaoNguocSoNguyen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = 0;
        while (true) {
            try {
                System.out.println("Nhap so luong phan tu (length):");
                length = Integer.parseInt(scanner.nextLine());
            } catch (Exception err) {
                System.out.println("\nError: Could not parse length to number, try agian.\n");
                continue;
            }
            if (length <= 0) {
                System.out.println("Error: Invalid length, try again");
                continue;
            }
            break;
        }

        int[] arr = new int[length];
        int index = 0;
        while (index < length) {
            int temp = 0;
            try {
                System.out.println("Nhap phan tu thu " + (index + 1));
                temp = Integer.parseInt(scanner.nextLine());
            } catch (Exception err) {
                System.out.println("Error: Could not parse element " + (index + 1) + " to number, try agian.");
                continue;
            }
            arr[index] = temp;
            index++;
        }

        Stack<Integer> stack = new Stack<>();

        System.out.println("Mang ban dau: ");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + "\t");
            stack.push(arr[i]);
        }

        System.out.println("\nMang sau khi dao nguoc: ");
        for (int element : arr) {
            element = stack.pop();
            System.out.print(element + "\t");
        }
    }
}