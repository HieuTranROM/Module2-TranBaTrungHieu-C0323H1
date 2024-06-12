package ss11.bai_tap.kiem_tra_chuoi_Palindrome_su_dung_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheck {
    public static boolean isPalindrome(String input) {
        input = input.toLowerCase(); // Chuyển đổi chuỗi thành chữ thường để so sánh

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Đưa từng ký tự vào stack và queue
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                stack.push(c);
                queue.add(c);
            }
        }

        // So sánh từng cặp ký tự trong stack và queue
        while (!stack.isEmpty() && !queue.isEmpty()) {
            char stackChar = stack.pop();
            char queueChar = queue.remove();
            if (stackChar != queueChar) {
                return false; // Không phải chuỗi Palindrome
            }
        }

        return true; // Là chuỗi Palindrome
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap chuoi: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Day la chuoi Palindrome.");
        } else {
            System.out.println("Day khong phai la chuoi Palindrome.");
        }

        scanner.close();
    }
}
