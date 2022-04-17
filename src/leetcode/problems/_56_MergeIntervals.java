package leetcode.problems;

import java.awt.*;
import java.util.*;
import java.util.stream.Stream;

/*
    Given a collection of intervals, merge all overlapping intervals.

    Example 1:

    Input: [[1,3],[2,6],[8,10],[15,18]]

    Output: [[1,6],[8,10],[15,18]]

    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

    Example 2:

    Input: [[1,4],[4,5]]

    Output: [[1,5]]

    Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/


public class _56_MergeIntervals {

    public static int[][] mergeNotSpaceOptimized(int[][] intervals) {

        if (intervals == null || intervals.length < 2) {
            return intervals;
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(intervals.length, Comparator.comparingInt(p -> p.x));

        for (int[] i : intervals) {
            pq.add(new Point(i[0], i[1]));
        }

        ArrayList<Point> list = new ArrayList<>();

        list.add(pq.poll());
        Point p;
        int currentStart;

        while (!pq.isEmpty()) {
            p = list.get(list.size() - 1);
            currentStart = pq.peek().x;
            if (currentStart >= p.x && currentStart <= p.y) {
                p.y = Math.max(p.y, pq.poll().y);
            } else {
                list.add(pq.poll());
            }
        }

        int[][] result = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            p = list.get(i);
            result[i][0] = p.x;
            result[i][1] = p.y;
        }
        return result;
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));

        ArrayList<int[]> result = new ArrayList<>();

        int[] last = null;

        for (int[] current : intervals) {
            if (!result.isEmpty()) {
                last = result.get(result.size() - 1);
            }
            if (result.isEmpty() || current[0] > last[1]) {
                result.add(current);
            } else {
                last[1] = Math.max(last[1], current[1]);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {8, 10},
                {2, 6},
                {1, 3},
                {15, 18}
        };

        Stream.of(merge(matrix)).forEach(e -> System.out.println(Arrays.toString(e)));

        System.out.println("***********************************");

        matrix = new int[][]{
                {1, 4},
                {4, 5}
        };

        Stream.of(merge(matrix)).forEach(e -> System.out.println(Arrays.toString(e)));

        System.out.println("***********************************");

        matrix = new int[][]{
                {1, 45},
                {4, 5}
        };

        Stream.of(merge(matrix)).forEach(e -> System.out.println(Arrays.toString(e)));
    }
}
