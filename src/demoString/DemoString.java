package demoString;

public class DemoString {
    public static void main(String[] args) {

        // Tạo một đối tượng String ban đầu
        String str = "Hello";

        // Thực hiện thao tác nối chuỗi
        str = str.concat(" World");

        // Thực hiện thao tác chèn chuỗi (không có phương thức chèn trực tiếp, phải dùng cách khác)
        str = new StringBuilder(str).insert(5, ",").toString();

        // Thực hiện thao tác thay thế chuỗi
        str = str.replace("Hello,", "Hello!!");

        // Thực hiện thao tác đảo ngược chuỗi (không có phương thức đảo ngược trực tiếp, phải dùng cách khác)
        str = new StringBuilder(str).reverse().toString();

        // In ra nội dung của str
        System.out.println("Final String: " + str); // Output: dlroW !!olleH
    }
}

