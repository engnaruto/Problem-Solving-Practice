package leetcode.problems;

/*
    Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected
    4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

    Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

    Example 1:

    [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     [0,0,0,0,0,0,0,1,1,1,0,0,0],
     [0,1,1,0,1,0,0,0,0,0,0,0,0],
     [0,1,0,0,1,1,0,0,1,0,1,0,0],
     [0,1,0,0,1,1,0,0,1,1,1,0,0],
     [0,0,0,0,0,0,0,0,0,0,1,0,0],
     [0,0,0,0,0,0,0,1,1,1,0,0,0],
     [0,0,0,0,0,0,0,1,1,0,0,0,0]]

    Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.

    Example 2:

    [[0,0,0,0,0,0,0,0]]

    Given the above grid, return 0.

    Note: The length of each dimension in the given grid does not exceed 50.
*/
public class _695_MaxAreaOfIsland {

    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {-1, 1, 0, 0};

    public static int dfs(int[][] grid, int i, int j) {
        int x, y;
        int area = 0;
        for (int k = 0; k < dx.length; k++) {
            x = i + dx[k];
            y = j + dy[k];

            if (x < grid.length && x >= 0 && y < grid[0].length && y >= 0 && grid[x][y] == 1) {
                grid[x][y] = 0;
                area++;
                area += dfs(grid, x, y);
            }
        }
        return area;
    }

    /*
        Time: O(N * M)
        Memory: O(N * M)
    */

    public static int maxAreaOfIsland(int[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        int area;
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    area = dfs(grid, i, j) + 1;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };

        System.out.println(maxAreaOfIsland(matrix));

        matrix = new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        System.out.println(maxAreaOfIsland(matrix));

        matrix = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        System.out.println(maxAreaOfIsland(matrix));

        matrix = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0}
        };

        System.out.println(maxAreaOfIsland(matrix));
    }
}
