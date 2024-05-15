package ss4.bai_tap.xay_dung_lop_QuadraticEquation;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = 0;
        double b = 0;
        double c = 0;

        System.out.println("Quadratic equation: ax2 + bx + c = 0");
        while (true) {
            try {
                System.out.print("Enter a, b, c: ");
                a = Double.parseDouble(scanner.nextLine());
                b = Double.parseDouble(scanner.nextLine());
                c = Double.parseDouble(scanner.nextLine());
            } catch (Exception err) {
                System.out.println("\n Error: Could not parse a or b or c to number. Please enter agian! \n");
                continue;
            }
            break;
        }

        QuadraticEquation qE = new QuadraticEquation(a, b, c);

        System.out.println("Caculate quadratic equation: " + qE.getA() + "x2 + " + qE.getB() + "x + " + qE.getC() + " = 0");

        System.out.println("Delta = " + qE.getDiscriminant());

        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has no solution!");
            } else {
                System.out.println("The equation has a solution: " + (-qE.getC() / qE.getB()));
            }
        } else {
            if (qE.getDiscriminant() < 0) {
                System.out.println("The equation has no solution!");
            } else if (qE.getDiscriminant() == 0) {
                System.out.println("The equation has a double solution: " + qE.getRoot1());
            } else {
                System.out.println("The equation has two solution: " + qE.getRoot1() + " and " + qE.getRoot2());
            }
        }
    }
}

