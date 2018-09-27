package cracking.the.coding.interview.problems;


import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/*
    8.10
    Paint Fill: Implement the "paint fill" function that one might see on many image editing programs.
    That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color,
    fill in the surrounding area until the color changes from the original color.
*/

public class _8_10_PaintFill {

    public static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    public static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};


    /*
        Time: O(M * N)
        Memory: O(M * N)
    */

    public static void paintFill(int[][] map, int x, int y, int color) {

        int oldColor = map[x][y];

        Queue<Point> q = new LinkedList<>();

        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point p = q.poll();
            map[p.x][p.y] = color;

            for (int i = 0; i < dx.length; i++) {
                int a = p.x + dx[i];
                int b = p.y + dy[i];

                if (a < map.length && b < map[0].length && a >= 0 && b >= 0 && map[a][b] == oldColor) {
                    q.add(new Point(a, b));
                }
            }
        }
    }


    /*
        Time: O(M * N)
        Memory: O(M * N)
    */

    public static void paintFillUsingDfs(int[][] map, int x, int y, int color, int oldColor) {
        if (x >= map.length || y >= map[0].length || x < 0 || y < 0 || map[x][y] != oldColor) {
            return;
        }

        map[x][y] = color;

        for (int i = 0; i < dx.length; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            paintFillUsingDfs(map, a, b, color, oldColor);
        }
    }


    public static void main(String[] args) {

        int[][] map = new int[][]{
                {0, 0, 0, 0, 0, 1, 1, 7, 2},
                {0, 3, 3, 3, 3, 1, 7, 1, 2},
                {0, 3, 4, 3, 3, 1, 7, 1, 2},
                {0, 4, 4, 4, 0, 7, 7, 1, 2},
                {0, 0, 0, 0, 0, 1, 7, 1, 2},
        };

        for (int[] i : map) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
        int y = 7;
        int x = 0;
        paintFill(map, x, y, 5);
//        paintFillUsingDfs(map, x, y, 5, map[x][y]);

        for (int[] i : map) {
            System.out.println(Arrays.toString(i));
        }
    }
}
