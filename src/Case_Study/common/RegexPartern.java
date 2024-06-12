package Case_Study.common;

import java.util.regex.Pattern;

public class RegexPartern {

    public static boolean validateName(String name) {
        String nameRegex = "^[a-zA-Z\\s]+$";
        return Pattern.matches(nameRegex, name);
    }

    public static boolean validateDate(String date) {
        String dateRegex = "^\\d{2}/\\d{2}/\\d{4}$";
        return Pattern.matches(dateRegex, date);
    }

    public static boolean validatePhone(String phone) {
        String phoneRegex = "\\d{10}";
        return Pattern.matches(phoneRegex, phone);
    }

    public static boolean validateEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(emailRegex, email);
    }

    public static boolean validateIdCard(String idCard) {
        String idCardRegex = "^\\d{12}$";
        return Pattern.matches(idCardRegex, idCard);
    }

    public static boolean validateBookingId(String bookingId) {
        String regex = "^B-\\d{3}$";
        return Pattern.matches(regex, bookingId);
    }

    public static boolean validateCustomerId(String customerId) {
        String regex = "^C-\\d{3}$";
        return Pattern.matches(regex, customerId);
    }

    public  static boolean validateContractId(String contractId) {
        String regex = "^CT-\\d{3}$";
        return Pattern.matches(regex, contractId);
    }
}


