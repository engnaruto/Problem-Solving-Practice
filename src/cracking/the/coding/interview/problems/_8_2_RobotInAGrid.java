
import java.util.ArrayList;
import java.util.Arrays;


/*
    8.2
    Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
    The robot can only move in two directions, right and down, but certain cells are "off limits" such that
    the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
    the bottom right.
*/

public class _8_2_RobotInAGrid {

    public static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + " - " + y + ")";
        }
    }


    public static int c, r;
    public static int[][] dp = new int[1000][1000];
    public static ArrayList<Pair> path = new ArrayList<>();
    public static int[][] map;
    public static boolean[][] visited = new boolean[1000][1000];

    /*
        Time: O(R * C)
        Memory: O(R * C)
    */

    public static int robotInAGridCountWays(int i, int j) {

        if (i >= r || j >= c) {
            return 0;
        }
        if (map[i][j] == 0) {
            return 0;
        }

        if (i == r - 1 && j == c - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int n = robotInAGridCountWays(i + 1, j) + robotInAGridCountWays(i, j + 1);

        return dp[i][j] = n;
    }

    /*
        Time: O(R * C)
        Memory: O(R * C)
    */

    public static boolean robotInAGrid(int i, int j) {
        if (i >= r || j >= c) {
            return false;
        }
        if (map[i][j] == 0) {
            return false;
        }

        if (i == r - 1 && j == c - 1) {
            path.add(new Pair(i, j));
            return true;
        }


        if (!visited[i][j]) {
            System.out.println(new Pair(i, j));
            boolean isFound = false;
            visited[i][j] = true;
            path.add(new Pair(i, j));
            isFound = robotInAGrid(i + 1, j);
            if (!isFound) {
                path.remove(path.size() - 1);
            }

            if (!isFound) {
                path.add(new Pair(i, j));
                isFound = robotInAGrid(i, j + 1);
                if (!isFound) {
                    path.remove(path.size() - 1);
                }
            }
            return isFound;
        }
        return false;
    }


    public static void main(String[] args) {
        map = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 0, 1},
        };

        for (int i = 0; i < dp[0].length; i++) {
            Arrays.fill(dp[i], -1);
            Arrays.fill(visited[i], false);
        }

        c = map[0].length;
        r = map.length;
        System.out.println(robotInAGridCountWays(0, 0));
        System.out.println(robotInAGrid(0, 0));
        System.out.println(path.toString());
    }

}
