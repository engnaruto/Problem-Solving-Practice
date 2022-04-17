package leetcode.problems;

import java.util.Arrays;


/*
    Given an integer matrix, find the length of the longest increasing path.

    From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally
    or move outside of the boundary (i.e. wrap-around is not allowed).

    Example 1:

    Input: nums =
    [

    ]

    Output: 4

    Explanation: The longest increasing path is [1, 2, 6, 9].

    Example 2:

    Input: nums =
    [
      [3,4,5],
      [3,2,6],
      [2,2,1]
    ]

    Output: 4

    Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/

public class _329_LongestIncreasingPathInAMatrix {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int[][] dp = new int[1000][1000];

    public static int solve(int[][] matrix, int i, int j) {
        if (i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int maxLength = 1;
        int x, y;

        for (int k = 0; k < dx.length; k++) {
            x = i + dx[k];
            y = j + dy[k];
            if (x < matrix.length && x >= 0 && y < matrix[0].length && y >= 0 && matrix[x][y] > matrix[i][j]) {
                maxLength = Math.max(maxLength, solve(matrix, x, y) + 1);
            }
        }

        return dp[i][j] = maxLength;
    }


    /*
        Time: O(N * M)
        Memory: O(N * M)
    */

    public static int longestIncreasingPath(int[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }

        int max = 0;

        dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, solve(matrix, i, j));
            }
        }
        return max;
    }


    public static void main(String args[]) throws Exception {

        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        System.out.println(longestIncreasingPath(matrix));

        matrix = new int[][]{
                {3, 4, 5},
                {3, 8, 6},
                {10, 9, 1}
        };

        System.out.println(longestIncreasingPath(matrix));
    }


}
