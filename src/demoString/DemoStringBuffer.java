package demoString;

public class DemoStringBuffer {
    public static void main(String[] args) {
        // Tạo một đối tượng StringBuffer ban đầu
        StringBuffer sb = new StringBuffer("Hello");

        // In ra nội dung ban đầu của sb
        System.out.println("Initial StringBuffer: " + sb.toString()); // Output: Hello

        // Thực hiện thao tác nối chuỗi
        sb.append(" World");

        // In ra nội dung của sb sau khi nối chuỗi
        System.out.println("After append: " + sb.toString()); // Output: Hello World

        // Thực hiện thao tác chèn chuỗi
        sb.insert(5, ",");

        // In ra nội dung của sb sau khi chèn
        System.out.println("After insert: " + sb.toString()); // Output: Hello, World

        // Thực hiện thao tác thay thế chuỗi
        sb.replace(5, 6, "!!");

        // In ra nội dung của sb sau khi thay thế
        System.out.println("After replace: " + sb.toString()); // Output: Hello!! World

        // Thực hiện thao tác đảo ngược chuỗi
        sb.reverse();

        // In ra nội dung của sb sau khi đảo ngược
        System.out.println("After reverse: " + sb.toString()); // Output: dlroW !!olleH
    }
}

