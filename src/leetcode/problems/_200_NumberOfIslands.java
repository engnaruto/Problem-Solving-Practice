package leetcode.problems;

/*
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded
    by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.

    Example 1:

    Input:
    11110
    11010
    11000
    00000

    Output: 1

    Example 2:

    Input:
    11000
    11000
    00100
    00011

    Output: 3
*/

public class _200_NumberOfIslands {

    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void dfs(char[][] grid, int i, int j) {
        int x, y;
        for (int k = 0; k < dx.length; k++) {
            x = i + dx[k];
            y = j + dy[k];

            if (x < grid.length && x >= 0 && y < grid[0].length && y >= 0 && grid[x][y] == '1') {
                grid[x][y] = '0';
                dfs(grid, x, y);
            }
        }
    }

    /*
        Time: O(N * M)
        Memory: O(N * M)
    */

    public static int numIslands(char[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        char[][] matrix = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };


        System.out.println(numIslands(matrix));

        matrix = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };


        System.out.println(numIslands(matrix));
    }
}
