package ss11.bai_tap.kiem_tra_dau_ngoac_trong_bieu_thuc_su_dung_Stack;

import java.util.Stack;

public class BracketChecker {
    public static boolean isExpressionValid(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                // Nếu gặp dấu ngoặc trái, đẩy nó vào Stack
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                // Nếu gặp dấu ngoặc phải
                if (stack.isEmpty()) {
                    // Nếu Stack rỗng mà vẫn gặp dấu ngoặc phải, biểu thức không hợp lệ
                    return false;
                } else {
                    // Lấy dấu ngoặc trái trên cùng của Stack ra
                    char top = stack.pop();
                    // Kiểm tra xem dấu ngoặc trái có khớp với dấu ngoặc phải hay không
                    if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                        return false; // Nếu không khớp, biểu thức không hợp lệ
                    }
                }
            }
            // Các kí tự khác không quan trọng, tiếp tục duyệt các kí tự tiếp theo
        }

        // Nếu đã duyệt qua toàn bộ biểu thức nhưng Stack vẫn chưa trống, biểu thức không hợp lệ
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expression1 = "s * (s – a) * (s – b) * (s – c)";
        String expression2 = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";
        String expression3 = "s * (s – a) * s – b) * (s – c)";
        String expression4 = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";

        System.out.println("Expression 1: " + isExpressionValid(expression1));
        System.out.println("Expression 2: " + isExpressionValid(expression2));
        System.out.println("Expression 3: " + isExpressionValid(expression3));
        System.out.println("Expression 4: " + isExpressionValid(expression4));
    }
}
