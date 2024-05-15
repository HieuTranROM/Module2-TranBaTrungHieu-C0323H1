package ss3.bai_tap;
import java.util.Scanner;

public class tim_phan_tu_lon_nhat_trong_mang_2_chieu {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Enter the number of rows and columns of the matrix
            System.out.print("Enter the number of rows: ");
            int rows = scanner.nextInt();
            System.out.print("Enter the number of columns: ");
            int columns = scanner.nextInt();

            // Create the matrix
            double[][] matrix = new double[rows][columns];

            // Enter the elements of the matrix
            System.out.println("Enter the elements of the matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print("Element at position (" + i + ", " + j + "): ");
                    matrix[i][j] = scanner.nextDouble();
                }
            }

            // Find the maximum element and its coordinates
            double maxElement = matrix[0][0];
            int maxRow = 0;
            int maxColumn = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (matrix[i][j] > maxElement) {
                        maxElement = matrix[i][j];
                        maxRow = i;
                        maxColumn = j;
                    }
                }
            }

            // Display the maximum element and its coordinates
            System.out.println("The maximum element is " + maxElement);
            System.out.println("Coordinates: (" + maxRow + ", " + maxColumn + ")");
        }
    }


