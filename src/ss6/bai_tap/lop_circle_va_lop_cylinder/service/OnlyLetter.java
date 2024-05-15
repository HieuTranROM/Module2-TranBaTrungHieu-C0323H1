package ss6.bai_tap.lop_circle_va_lop_cylinder.service;

public class OnlyLetter {
    public boolean isOnlyLetters(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (!Character.isLetter(arr[i])) {
                return false;
            }
        }
        return true;
    }
}

