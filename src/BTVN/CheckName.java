package BTVN;

import java.util.Scanner;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CheckName {
/*    Bài tập về nhà: Viết 1 regex check tên tiếng Việt.
    Lưu ý: Nếu người dùng nhập Trương tấn Hải thì xử lý theo 1 trong 2 cách bên dưới
    Cách 1: tích hợp vào regex và thông báo lỗi
    Cách 2: viết 1 hàm định dạng lại chuỗi. Giúp khách hàng in hoa chữ T lên*/


    // Biểu thức chính quy để kiểm tra tên
    private static final String NAME_REGEX = "^[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯàáâãèéêìíòóôõùúăđĩũơưẠ-ỹ]{1,25}(?: [A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯàáâãèéêìíòóôõùúăđĩũơưẠ-ỹ]{1,25})*$";

    // Hàm kiểm tra tên hợp lệ
    public static boolean isValidVietnameseName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    // Hàm định dạng lại tên
    public static String formatVietnameseName(String name) {
        String[] words = name.toLowerCase().split("\\s+");
        StringBuilder formattedName = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                formattedName.append(Character.toUpperCase(word.charAt(0)));
                formattedName.append(word.substring(1)).append(" ");
            }
        }

        // Loại bỏ dấu cách thừa ở cuối chuỗi
        return formattedName.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên của bạn: ");
        String inputName = scanner.nextLine();

        if (isValidVietnameseName(inputName)) {
            System.out.println(inputName + " là tên hợp lệ.");
        } else {
            System.out.println(inputName + " không phải là tên hợp lệ.");
            String formattedName = formatVietnameseName(inputName);
            System.out.println("Tên sau khi định dạng lại: " + formattedName);

            // Kiểm tra lại tên sau khi định dạng
            if (isValidVietnameseName(formattedName)) {
                System.out.println(formattedName + " là tên hợp lệ sau khi định dạng lại.");
            } else {
                System.out.println(formattedName + " vẫn không phải là tên hợp lệ sau khi định dạng lại.");
            }
        }

        scanner.close();
    }
}

