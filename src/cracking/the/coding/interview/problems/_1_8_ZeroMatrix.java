import java.util.*;

/*
    1.8
    Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
    column are set to 0.
*/

public class _1_8_ZeroMatrix {

     /*
        Time: O(NM)
        Memory: O(1)
     */

    public static void zeroMatrixInPlace(int[][] matrix) {

        boolean rowHasZero = false;
        boolean columnHasZero = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                columnHasZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowHasZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                nullifyColumn(matrix, i);
            }
        }

        if (rowHasZero) {
            Arrays.fill(matrix[0], 0);
        }

        if (columnHasZero) {
            nullifyColumn(matrix, 0);
        }
    }

    /*
        Time: O(NM)
        Memory: O(N + M)
    */

    public static void zeroMatrix(int[][] matrix) {

        boolean[] zerosRows = new boolean[matrix.length];
        boolean[] zerosColumns = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zerosRows[i] = true;
                    zerosColumns[j] = true;
                }
            }
        }

        for (int i = 0; i < zerosRows.length; i++) {
            if (zerosRows[i]) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int i = 0; i < zerosColumns.length; i++) {
            if (zerosColumns[i]) {
                nullifyColumn(matrix, i);
            }
        }
    }

    private static void nullifyColumn(int[][] matrix, int i) {
        for (int j = 0; j < matrix.length; j++) {
            matrix[j][i] = 0;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] copyMatrix(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static void main(String[] args) {

        int[][][] tests = {
                {
                        {1, 0, 1, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1}
                }
        };

        for (int[][] test : tests) {
            int[][] matrix = copyMatrix(test);
            printMatrix(matrix);
            zeroMatrix(matrix);
            System.out.println("=================");
            printMatrix(matrix);
            System.out.println("*****************");
            matrix = copyMatrix(test);
            zeroMatrixInPlace(matrix);
            printMatrix(matrix);
            System.out.println("*****************");
        }
    }
}