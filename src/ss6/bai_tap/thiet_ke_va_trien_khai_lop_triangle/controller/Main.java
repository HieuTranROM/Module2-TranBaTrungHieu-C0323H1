package ss6.bai_tap.thiet_ke_va_trien_khai_lop_triangle.controller;

import ss6.bai_tap.thiet_ke_va_trien_khai_lop_triangle.model.Circle;
import ss6.bai_tap.thiet_ke_va_trien_khai_lop_triangle.model.Rectangle;
import ss6.bai_tap.thiet_ke_va_trien_khai_lop_triangle.model.Square;
import ss6.bai_tap.thiet_ke_va_trien_khai_lop_triangle.service.IResizeable;

public class Main {
    public static void main(String[] args) {
        Square[] squares = new Square[2];
        squares[0] = new Circle(2.0);
        squares[1]= new Rectangle(3.0,5.0);

        double percent = Math.random()*100 +1;
        System.out.println("percent " + percent );

        for (Square square : squares) {
            if (square instanceof Circle) {
                System.out.println("before circle area: " + ((Circle) square).getArea());
            } else if ( square instanceof Rectangle) {
                System.out.println("before rectangle area: " + ((Rectangle) square).getArea());
            }
        }
        System.out.println("AFTER");

        for (Square square : squares) {
            if (square instanceof Circle) {
                IResizeable resCircle = (Circle) square;
                resCircle.resize(percent);
                System.out.println("after circle area: " + ((Circle) square).getArea());
            } else if ( square instanceof Rectangle) {
                IResizeable resRectangle = (Rectangle) square;
                resRectangle.resize(percent);
                System.out.println("before rectangle area: " + ((Rectangle) square).getArea());
            }
        }
    }
}