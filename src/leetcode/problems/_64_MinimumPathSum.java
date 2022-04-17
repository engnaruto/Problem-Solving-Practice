package leetcode.problems;


import java.util.Arrays;

/*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.

    Example:

    Input:
    [
      [1,3,1],
      [1,5,1],
      [4,2,1]
    ]

    Output: 7

    Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/


public class _64_MinimumPathSum {

    public static int dp[][];

    public static int solve(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE / 10;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        return dp[i][j] = Math.min(solve(grid, i + 1, j), solve(grid, i, j + 1)) + grid[i][j];
    }


    /*
        Time: O(N * M)
        Memory: O(N * M)
    */

    public static int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(grid, 0, 0);
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println(minPathSum(grid));;
    }
}
