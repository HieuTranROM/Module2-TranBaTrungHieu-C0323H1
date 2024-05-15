package ss6.bai_tap.lop_circle_va_lop_cylinder.service;

import ss6.bai_tap.lop_circle_va_lop_cylinder.model.Circle;

import java.util.Scanner;

public class CircleService {

    private Scanner scanner = new Scanner(System.in);
    private OnlyLetter onlyLetter = new OnlyLetter();
    private Circle circle;

    public void add() {
        double radius;
        String color;
        while (true) {
            System.out.println("\n-----Enter Circle-----");
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
            } else {
                break;
            }
        }

        circle = new Circle(radius, color);
    }

    public void display() {
        System.out.println(circle.toString());
    }

    public void getPerimeter() {
        System.out.printf("Perimeter: %.2f%n", circle.getPerimeter());
    }

    public void getArea() {
        System.out.printf("Area: %.2f%n", circle.getArea());
    }
}

