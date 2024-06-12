package ss11.bai_tap.dao_nguoc_phan_tu_trong_mang_so_nguyen;

import java.util.Scanner;
import java.util.Stack;

public class DaoNguocChuoi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao 1 chuoi:");
        String intputString = scanner.nextLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < intputString.length(); i++) {
            stack.push(intputString.charAt(i));
        }

        StringBuilder str = new StringBuilder(intputString.length());
        for (int i = 0; i < intputString.length(); i++) {
            str.append(stack.pop());
        }

        System.out.println("Chuoi sau khi dao nguoc: " + str);


    }
}


