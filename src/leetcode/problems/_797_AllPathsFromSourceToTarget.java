package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/*
    Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them
    in any order.

    The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j
    for which the edge (i, j) exists.

    Example:

    Input: [[1,2], [3], [3], []]

    Output: [[0,1,3],[0,2,3]]

    Explanation: The graph looks like this:

    0--->1
    |    |
    v    v
    2--->3

    There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

    Note:
        The number of nodes in the graph will be in the range [2, 15].
        You can print different paths in any order, but you should keep the order of nodes inside one path.
*/


public class _797_AllPathsFromSourceToTarget {

    /*
        Time: O(2 ^ N)
        Memory: O(N ^ 2 * N)
    */

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();

        ArrayList<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, result, path);

        return result;
    }

    private static void dfs(int[][] graph, int index, List<List<Integer>> result, ArrayList<Integer> path) {
        if (index == graph.length - 1) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < graph[index].length; i++) {
            path.add(graph[index][i]);
            dfs(graph, graph[index][i], result, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1, 2},
                {3},
                {3},
                {}
        };

        System.out.println(allPathsSourceTarget(graph));
    }
}
