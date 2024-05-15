package ss6.bai_tap.lop_point2d_va_lop_point3d.service;
import ss6.bai_tap.lop_point2d_va_lop_point3d.model.Point2D;
import ss6.bai_tap.lop_point2d_va_lop_point3d.model.Point3D;
import java.util.Scanner;

public class Point3DService {

        private Point3D point3D;

        public void add() {
            Scanner scanner = new Scanner(System.in);
            float x;
            float y;
            float z;
            System.out.println("\n-----Point 3D-----");
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
                try {
                    System.out.println("Enter z:");
                    z = Float.parseFloat(scanner.nextLine());
                } catch (Exception err) {
                    System.out.println("\nError: Could not parse z to number.\nPlease enter agian!\n");
                    continue;
                }
                break;
            }

            point3D = new Point3D(x,y,z);
        }

        public void display() {
            System.out.println(point3D.toString());
        }
    }

