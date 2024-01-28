import java.util.Arrays;
import java.util.Scanner;

public class MatrixSortingAndDiagonalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the order of the square matrix
        System.out.print("Enter the order of the square matrix: ");
        int order = scanner.nextInt();

        // Create the square matrix
        int[][] matrix = new int[order][order];

        // Input the elements of the matrix
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Sort non-boundary elements of the matrix
        sortNonBoundaryElements(matrix);

        // Display the sorted matrix
        System.out.println("Sorted matrix (non-boundary elements):");
        displayMatrix(matrix);

        // Calculate and display the sum of primary and secondary diagonal elements together
        int diagonalSum = calculateDiagonalSum(matrix);
        System.out.println("Sum of both primary and secondary diagonal elements: " + diagonalSum);

        scanner.close();
    }

    // Function to sort non-boundary elements of the matrix
    private static void sortNonBoundaryElements(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] nonBoundaryElements = new int[(rows - 2) * (cols - 2)];
        int index = 0;

        // Extract non-boundary elements
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                nonBoundaryElements[index++] = matrix[i][j];
            }
        }

        // Sort non-boundary elements
        Arrays.sort(nonBoundaryElements);

        // Insert sorted non-boundary elements back into the matrix
        index = 0;
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                matrix[i][j] = nonBoundaryElements[index++];
            }
        }
    }

    // Function to calculate the sum of primary and secondary diagonal elements together
    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i]; // Primary diagonal
            sum += matrix[i][n - i - 1]; // Secondary diagonal
        }
        // If the order of the matrix is odd, one common element is added twice, so subtract it once
        if (n % 2 == 1) {
            sum -= matrix[n / 2][n / 2];
        }
        return sum;
    }

    // Function to display the matrix
    private static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
