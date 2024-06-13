package Thi_thuc_hanh_module_2.utils;

public class RegexPattern {
    public static final String NAME_PATTERN = "^[a-zA-Z\\s]{4,50}$";

    public static final String DATE_PATTERN = "^\\d{2}/\\d{2}/\\d{4}$";

    public static final String PHONE_PATTERN = "^0(90|91)\\d{8}$";

    public static boolean validateName(String name) {
        return name.matches(NAME_PATTERN);
    }

    public static boolean validateDate(String date) {
        return date.matches(DATE_PATTERN);
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches(PHONE_PATTERN);
    }
}
