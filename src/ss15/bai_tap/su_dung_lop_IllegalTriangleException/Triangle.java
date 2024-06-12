package ss15.bai_tap.su_dung_lop_IllegalTriangleException;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) throws IllegalRightTriangleException{
        Scanner scanner = new Scanner(System.in);
        double side1, side2, side3;
        try {
            System.out.println("Nhập 3 cạnh của tam giác:");
            System.out.print("Cạnh 1 = ");
            side1 = Double.parseDouble(scanner.nextLine());
            System.out.print("Cạnh 2 = ");
            side2 = Double.parseDouble(scanner.nextLine());
            System.out.print("Cạnh 3 = ");
            side3 = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Không thể chuyển canh 1 hoặc cạnh 2 hoặc cạnh 3 thành số.");
        }

        if (side1 <= 0) {
            throw new IllegalRightTriangleException("Cạnh 1 bé hơn hoặc bằng 0.");
        } else if (side2 <= 0) {
            throw new IllegalRightTriangleException("Cạnh 2 bé hơn hoặc bằng 0.");
        } else if (side3 <= 0) {
            throw new IllegalRightTriangleException("Cạnh 3 bé hơn hoặc bằng 0.");
        }

        if (side1 > side2 + side3) {
            throw new IllegalRightTriangleException("Cạnh 1 lớn hơn tổng 2 cạnh còn lại.");
        } else if (side2 > side1 + side3) {
            throw new IllegalRightTriangleException("Cạnh 2 lớn hơn tổng 2 cạnh còn lại.");
        } else if (side3 > side1 + side2) {
            throw new IllegalRightTriangleException("Cạnh 3 lớn hơn tổng 2 cạnh còn lại.");
        }
    }
}