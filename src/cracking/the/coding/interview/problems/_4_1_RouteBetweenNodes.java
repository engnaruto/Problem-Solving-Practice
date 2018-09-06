package cracking.the.coding.interview.problems;

import java.util.LinkedList;
import java.util.Queue;

/*
    4.1
    Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
    route between two nodes.
*/

public class _4_1_RouteBetweenNodes {

    public static LinkedList<Integer>[] graph;


    /*
         Time: O(N)
         Memory: O(N)
    */

    public static boolean bfs(int source, int destination) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        q.add(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int n = q.poll();

            for (int i : graph[n]) {
                if (!visited[i]) {
                    if (i == destination) {
                        return true;
                    } else {
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        graph = new LinkedList[6];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }

        graph[0].add(1);
        graph[0].add(4);
        graph[0].add(5);
        graph[1].add(4);
        graph[1].add(3);
        graph[2].add(1);
        graph[3].add(2);
        graph[3].add(4);

        System.out.println(bfs(0, 4));
        System.out.println(bfs(0, 2));
        System.out.println(bfs(4, 0));

    }
}
