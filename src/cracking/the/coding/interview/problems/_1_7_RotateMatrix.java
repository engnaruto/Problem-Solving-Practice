import java.util.*;

/*
    1.7
    Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
    bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
*/

public class _1_7_RotateMatrix {

    /*
        Time: O(N ^ 2)
        Memory: O(1)
    */

    public static void rotateMatrix(int[][] matrix) {
        diagonalMatrixMirroring(matrix);
        verticalMatrixMirroring(matrix);
    }

    public static void diagonalMatrixMirroring(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void verticalMatrixMirroring(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int length = matrix[0].length - 1;
            for (int j = 0; j <= matrix[0].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length - j];
                matrix[i][length - j] = temp;
            }
        }
    }

    public static void print(int[][] matrix) {
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {

        int[][][] tests = {
                {
                        {1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 20},
                        {21, 22, 23, 24, 25}
                }
        };

        for (int[][] test : tests) {
            rotateMatrix(test);
            print(test);
            System.out.println("====================");
            rotateMatrix(test);
            print(test);
            System.out.println("====================");
            rotateMatrix(test);
            print(test);
            System.out.println("====================");
            rotateMatrix(test);
            print(test);
        }
    }
}