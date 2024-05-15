package ss3.bai_tap;

import java.util.Scanner;

public class tinh_tong_cac_so_o_mot_cot_xac_dinh {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of rows and columns from the user
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        double[][] matrix = new double[rows][columns];

        // Input values for each element in the matrix from the user
        System.out.println("Enter values for each element in the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // Input the index of the column from the user
        System.out.print("Enter the index of the column (starting from 0): ");
        int columnOrder = scanner.nextInt();

        // Calculate the sum of the elements in the column
        double columnSum = 0;
        for (int i = 0; i < rows; i++) {
            columnSum += matrix[i][columnOrder];
        }

        // Display the sum of the elements in the column
        System.out.println("The sum of the elements in the column is: " + columnSum);

        scanner.close();
    }
}



