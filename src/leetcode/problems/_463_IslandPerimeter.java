package leetcode.problems;

/*
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.

Determine the perimeter of the island.

Example:

Input:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:
*/

public class _463_IslandPerimeter {

    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {-1, 1, 0, 0};

    public static int getPerimeter(int[][] grid, int i, int j) {
        int perimeter = 0;
        int x, y;
        for (int k = 0; k < dx.length; k++) {
            x = i + dx[k];
            y = j + dy[k];

            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 0) {
                perimeter++;
            } else if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
                perimeter++;
            }
        }
        return perimeter;
    }

    public static int dfs(int[][] grid, boolean[][] visited, int i, int j) {

        visited[i][j] = true;

        int x, y;
        int perimeter = getPerimeter(grid, i, j);

        for (int k = 0; k < dx.length; k++) {
            x = i + dx[k];
            y = j + dy[k];

            if (x < grid.length && x >= 0 && y < grid[0].length && y >= 0 && grid[x][y] == 1 && !visited[x][y]) {
                perimeter += dfs(grid, visited, x, y);
            }
        }
        return perimeter;
    }

    /*
        Time: O(N * M)
        Memory: O(N * M)
    */

    public static int islandPerimeter(int[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, visited, i, j);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        System.out.println(islandPerimeter(matrix));

        matrix = new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        System.out.println(islandPerimeter(matrix)); // 16

        matrix = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        System.out.println(islandPerimeter(matrix));

        matrix = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0}
        };

        System.out.println(islandPerimeter(matrix));

        matrix = new int[][]{
                {1, 1},
                {1, 0}
        };

        System.out.println(islandPerimeter(matrix));
    }
}
