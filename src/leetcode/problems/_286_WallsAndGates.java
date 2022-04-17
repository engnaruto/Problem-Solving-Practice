package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _286_WallsAndGates {

    final public static int INF = Integer.MAX_VALUE;


    public static class Pair implements Comparable<Pair> {
        int i, j, distance;

        Pair(int i, int j, int distance) {
            this.i = i;
            this.j = j;
            this.distance = distance;
        }

        @Override
        public int compareTo(Pair o) {
            return distance - o.distance;
        }
    }

    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    private static void dijkstra(int[][] graph, int i, int j) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        Pair p = new Pair(i, j, 0);

        pq.add(p);

        int distance;

        int x, y;
        while (!pq.isEmpty()) {
            p = pq.poll();

            distance = p.distance;
            for (int k = 0; k < dx.length; k++) {
                x = p.i + dx[k];
                y = p.j + dy[k];

                if (x < graph.length && x >= 0 && y < graph[0].length && y >= 0 && (distance + 1) < graph[x][y]) {
                    graph[x][y] = distance + 1;
                    pq.add(new Pair(x, y, distance + 1));

                }
            }
        }


    }

    public static void wallsAndGates(int[][] graph) {

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 0) {
                    dijkstra(graph, i, j);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };


        wallsAndGates(graph);

        for (int[] i : graph) {
            System.out.println(Arrays.toString(i));
        }

        graph = new int[][]{
                {INF, -1  , 0,  INF},
                {INF, -1, INF, -1},
                {INF, -1  , INF, -1},
                {0  , -1 , INF, 0}
        };


        wallsAndGates(graph);

        System.out.println("*************");

        for (int[] i : graph) {
            System.out.println(Arrays.toString(i));
        }
    }
}
