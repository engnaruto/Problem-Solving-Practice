package cracking.the.coding.interview.problems;

import java.awt.*;


/*
    10.9
    Sorted Matrix Search: Given an M x N matrix in which each row and each column is sorted in
    ascending order, write a method to find an element.
*/

public class _10_9_SortedMatrixSearch {

    private static Point binarySearch(int[] matrix, int target, int sx, int sy, int ey) {
        int my;
        while (sy <= ey) {
            my = (sy + ey) / 2;

            if (matrix[my] == target) {
                return new Point(sx, my);
            } else if (matrix[my] < target) {
                sy = my + 1;
            } else {
                ey = my - 1;
            }
        }
        return new Point(-1, -1);
    }


    /*
        Time: O(Log(N * M))
        Memory: O(1)
    */

    public static Point sortedMatrixSearch(int[][] matrix, int target) {

        int sx = 0;
        int sy = 0;
        int ex = matrix.length;
        int ey = matrix[0].length;

        int mx, my;

        while (sx <= ex && sy <= ey) {
            mx = (sx + ex) / 2;
            my = (sy + ey) / 2;

            System.out.println("(" + sx + ", " + sy + ")" + "(" + mx + ", " + my + ")" + "(" + ex + ", " + ey + ") - " + matrix[mx][my]);

            if (matrix[mx][my] == target) {
                return new Point(mx, my);
            } else if (matrix[mx][my] < target) {
                sx = mx;
                sy = 0;

                if (ex - sx <= 1) {
                    Point p = binarySearch(matrix[sx], target, sx, sy, ey);

                    if (p.equals(new Point(-1, -1)) && ex - sx == 1) {
                        p = binarySearch(matrix[ex], target, ex, sy, ey);
                    }
                    return p;
                }
            } else {
                ex = mx;
                ey = matrix[0].length;
                if (ex - sx <= 1) {
                    Point p = binarySearch(matrix[sx], target, sx, sy, ey);

                    if (p.equals(new Point(-1, -1)) && ex - sx == 1) {
                        p = binarySearch(matrix[ex], target, ex, sy, ey);
                    }
                    return p;
                }
            }

        }
        return new Point(-1, -1);
    }


    public static void main(String[] args) {
//        int[][] matrix = {
//                {0, 2, 4, 16, 18},
//                {10, 15, 20, 22, 30},
//                {20, 27, 32, 35, 40},
//                {30, 33, 40, 44, 45},
//                {41, 44, 46, 50, 51},
//                {50, 56, 59, 60, 66}
//        };

        int[][] matrix = {

                {-3, 10, 31, 40},
                {10, 33, 40, 66},
                {22, 43, 161, 70}
        };
        System.out.println(sortedMatrixSearch(matrix, 22));
    }
}
