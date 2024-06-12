package ss19.bai_tap.validate_so_dien_thoai;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PhoneNumberValidator {
    public static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^\\([0-9]{2}\\)-\\(0[0-9]{9}\\)$"; // Regular Expression

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String validPhoneNumber = "(84)-(0978489648)";
        String invalidPhoneNumber1 = "(a8)-(22222222)";
        String invalidPhoneNumber2 = "(84)-(123456789)";

        System.out.println(validPhoneNumber + " is valid: " + isValidPhoneNumber(validPhoneNumber));
        System.out.println(invalidPhoneNumber1 + " is valid: " + isValidPhoneNumber(invalidPhoneNumber1));
        System.out.println(invalidPhoneNumber2 + " is valid: " + isValidPhoneNumber(invalidPhoneNumber2));
    }
}
