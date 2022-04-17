package leetcode.problems;


/*
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

    The robot can only move either down or right at any point in time. The robot is trying to reach
    the bottom-right corner of the grid (marked 'Finish' in the diagram below).

    How many possible unique paths are there?


    Above is a 7 x 3 grid. How many possible unique paths are there?

    Note: m and n will be at most 100.

    Example 1:

    Input: m = 3, n = 2

    Output: 3

    Explanation:

    From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:

        1. Right -> Right -> Down
        2. Right -> Down -> Right
        3. Down -> Right -> Right

    Example 2:

    Input: m = 7, n = 3

    Output: 28
*/

public class _62_UniquePaths {

    /*
        Time: O(N * M)
        Memory: O(N * M)
    */

    public static int dfs(int[][] dp, int i, int j, int m, int n) {
        if (i == m || j == n) {
            return dp[i][j] = 0;
        }

        if (i == m - 1 && j == n - 1) {
            return dp[i][j] = 1;
        }

        if (dp[i][j]!=0){
            return dp[i][j];
        }

        int downPath = dfs(dp, i + 1, j, m, n);
        int rightPath = dfs(dp, i, j + 1, m, n);

        return dp[i][j] = rightPath + downPath;
    }

    public static int uniquePaths(int m, int n) {
        return dfs(new int[m+1][n+1],0, 0, m, n);
    }


    public static void main(String[] args) {
        int m = 2;
        int n = 3;

        System.out.println(uniquePaths(m, n));

        m = 7;
        n = 3;

        System.out.println(uniquePaths(m, n));

        m = 51;
        n = 9;

        System.out.println(uniquePaths(m, n));
    }
}
