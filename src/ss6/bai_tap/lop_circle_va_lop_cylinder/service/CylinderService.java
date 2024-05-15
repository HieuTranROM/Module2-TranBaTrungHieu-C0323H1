package ss6.bai_tap.lop_circle_va_lop_cylinder.service;

import ss6.bai_tap.lop_circle_va_lop_cylinder.model.Cylinder;

import java.util.Scanner;

public class CylinderService {

    Scanner scanner = new Scanner(System.in);
    private OnlyLetter onlyLetter = new OnlyLetter();
    private Cylinder cylinder;

    public void add() {
        double radius;
        String color;
        double height;
        while (true) {
            System.out.println("\n-----Enter Cylinder-----");
            try {
                System.out.println("Enter radius:");
                radius = Double.parseDouble(scanner.nextLine());
            } catch (Exception err) {
                System.out.println("\nError: Could not parse radius to number.\nPlease enter agian!\n");
                continue;
            }
            System.out.println("Enter color:");
            color = scanner.nextLine();
            if (color.trim().isEmpty() || !onlyLetter.isOnlyLetters(color)) {
                System.out.println("\nError: Invalid color.\nPlease enter agian!\n");
                continue;
            }
            try {
                System.out.println("Enter height:");
                height = Double.parseDouble(scanner.nextLine());
            } catch (Exception err) {
                System.out.println("\nError: Could not parse height to number.\nPlease enter agian!\n");
                continue;
            }
            break;
        }
        cylinder = new Cylinder(radius, color, height);
    }

    public void display() {
        System.out.println(cylinder.toString());
    }

    public void getVolume() {
        System.out.printf("Volume: %.2f%n", cylinder.volume());
    }
}

