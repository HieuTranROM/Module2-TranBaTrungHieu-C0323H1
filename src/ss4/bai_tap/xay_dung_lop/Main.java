package ss4.bai_tap.xay_dung_lop;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan(3, true, 10, "Yellow");
        Fan fan2 = new Fan(2, false, 5, "Blue");

        System.out.println("Fan 1: " + fan1.to_string());
        System.out.println("Fan 1: " + fan2.to_string());
    }
}