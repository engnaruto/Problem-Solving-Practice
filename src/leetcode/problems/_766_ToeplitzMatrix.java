
/*
    A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

    Now given an M x N matrix, return True if and only if the matrix is Toeplitz.


    Example 1:

    Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]

    Output: True

    Explanation:
    1234
    5123
    9512

    In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", and in each diagonal all elements are the same, so the answer is True.

    Example 2:

    Input: matrix = [[1,2],[2,2]]

    Output: False

    Explanation:
    The diagonal "[1, 2]" has different elements.

    Note:
    1- matrix will be a 2D array of integers.
    2- matrix will have a number of rows and columns in range [1, 20].
    3- matrix[i][j] will be integers in range [0, 99].
*/

public class _766_ToeplitzMatrix {

    /*
        Time: O(NM)
        Memory: O(1)
    */

    public static boolean isToeplitzMatrixSimpleSolution(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
        Time: O(NM)
        Memory: O(1)
    */

    public static boolean isToeplitzMatrix(int[][] matrix) {

        int row = 0;
        int col = 0;

        for (int i = 0; i < matrix[0].length - 1; i++) {
            row = 0;
            col = i;
            while (row < (matrix.length - 1) && col < (matrix[0].length - 1)) {
                if (matrix[row][col] != matrix[row + 1][col + 1]) {
                    return false;
                }
                row++;
                col++;
            }
        }

        for (int i = 1; i < matrix.length - 1; i++) {
            row = i;
            col = 0;
            while (row < (matrix.length - 1) && col < (matrix[0].length - 1)) {
                if (matrix[row][col] != matrix[row + 1][col + 1]) {
                    return false;
                }
                row++;
                col++;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][][] tests = {
                {
                        {0, 1},
                        {2, 1}
                }
        };

        for (int[][] test : tests) {
            System.out.println(isToeplitzMatrix(test));
            System.out.println(isToeplitzMatrixSimpleSolution(test));
        }
    }
}
