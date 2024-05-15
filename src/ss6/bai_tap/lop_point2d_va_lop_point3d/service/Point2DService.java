package ss6.bai_tap.lop_point2d_va_lop_point3d.service;
import ss6.bai_tap.lop_point2d_va_lop_point3d.model.Point2D;
import java.util.Scanner;

public class Point2DService {

        private Point2D point2D;

        public void add() {
            Scanner scanner = new Scanner(System.in);
            float x;
            float y;
            System.out.println("\n-----Point 2D-----");
            while (true) {
                try {
                    System.out.println("Enter x:");
                    x = Float.parseFloat(scanner.nextLine());
                } catch (Exception err) {
                    System.out.println("\nError: Could not parse x to number.\nPlease enter agian!\n");
                    continue;
                }
                try {
                    System.out.println("Enter y:");
                    y = Float.parseFloat(scanner.nextLine());
                } catch (Exception err) {
                    System.out.println("\nError: Could not parse y to number.\nPlease enter agian!\n");
                    continue;
                }
                break;
            }

            point2D = new Point2D(x,y);
        }

        public void display() {
            System.out.println(point2D.toString());
        }
    }

