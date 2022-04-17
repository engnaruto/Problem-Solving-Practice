package leetcode.problems;


/*
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

    The robot can only move either down or right at any point in time. The robot is trying to reach
    the bottom-right corner of the grid (marked 'Finish' in the diagram below).

    Now consider if some obstacles are added to the grids. How many unique paths would there be?

    An obstacle and empty space is marked as 1 and 0 respectively in the grid.

    Note: m and n will be at most 100.

    Example 1:

    Input:

    [
      [0,0,0],
      [0,1,0],
      [0,0,0]
    ]

    Output: 2

    Explanation:

    There is one obstacle in the middle of the 3x3 grid above.

    There are two ways to reach the bottom-right corner:

        1. Right -> Right -> Down -> Down
        2. Down -> Down -> Right -> Right
*/


import java.util.Arrays;

public class _63_UniquePathsII {

     /*
        Time: O(N * M)
        Memory: O(N * M)
    */

    public static int dfs(int[][] graph, int[][] dp, int i, int j) {

        if (i == graph.length || j == graph[0].length || graph[i][j] == 1) {
            return dp[i][j] = 0;
        }

        if (i == graph.length - 1 && j == graph[0].length - 1) {
            return dp[i][j] = 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int downPath = dfs(graph, dp, i + 1, j);
        int rightPath = dfs(graph, dp, i, j + 1);

        return dp[i][j] = rightPath + downPath;
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {


        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(obstacleGrid, dp, 0, 0);
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        System.out.println(uniquePathsWithObstacles(graph));

        graph = new int[][]{
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        };

        System.out.println(uniquePathsWithObstacles(graph));

        graph = new int[][]{
                {0, 0, 0},
                {1, 1, 1},
                {0, 0, 0}
        };

        System.out.println(uniquePathsWithObstacles(graph));
    }

}
