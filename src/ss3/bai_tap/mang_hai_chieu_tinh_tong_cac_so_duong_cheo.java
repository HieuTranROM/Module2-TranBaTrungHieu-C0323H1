package ss3.bai_tap;

import java.util.Scanner;

public class mang_hai_chieu_tinh_tong_cac_so_duong_cheo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the square matrix from the user
        System.out.print("Enter the size of the square matrix: ");
        int size = scanner.nextInt();

        double[][] matrix = new double[size][size];

        // Input values for each element in the matrix from the user
        System.out.println("Enter values for each element in the matrix:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // Calculate the sum of the elements in the main diagonal
        double diagonalSum = 0;
        for (int i = 0; i < size; i++) {
            diagonalSum += matrix[i][i];
        }

        // Display the sum of the elements in the main diagonal
        System.out.println("The sum of the elements in the main diagonal is: " + diagonalSum);

        scanner.close();
    }
}


