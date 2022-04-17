package leetcode.problems;


import java.util.ArrayList;
import java.util.Arrays;


/*
    There are a total of n courses you have to take, labeled from 0 to n - 1.

    Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
    which is expressed as a pair: [0,1]

    Given the total number of courses and a list of prerequisite pairs, return the ordering of courses
    you should take to finish all courses.

    There may be multiple correct orders, you just need to return one of them. If it is impossible to finish
    all courses, return an empty array.

    Example 1:

    Input: 2, [[1,0]]

    Output: [0,1]

    Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
                 course 0. So the correct course order is [0,1].

    Example 2:

    Input: 4, [[1,0],[2,0],[3,1],[3,2]]

    Output: [0,1,2,3] or [0,2,1,3]

    Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
                 courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
                 So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
    Note:

        1- The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
           Read more about how a graph is represented.
        2- You may assume that there are no duplicate edges in the input prerequisites.
*/

public class _210_CourseScheduleII {

    public static class Wrapper {
        int index = 0;
    }


    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] order = new int[numCourses];
        Wrapper index = new Wrapper();
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : prerequisites) {
            graph[e[0]].add(e[1]);
        }

//        while (!isFinished) {
        for (int i = 0; i < numCourses; i++) {
            dfs(graph, order, visited, index, i);
        }

        if (index.index == numCourses) {
            return order;
        } else {
            return new int[0];
        }
    }

    private static boolean dfs(ArrayList<Integer>[] graph, int[] order, boolean[] visited, Wrapper index, int course) {

        if (graph[course].isEmpty()) {
            if (!isFinished(order, index.index, course)) {
                order[index.index] = course;
                index.index++;
            }
            return true;
        }

        int i = 0;
        visited[course] = true;
        int dependingCourse = 0;
        while (i < graph[course].size()) {
            dependingCourse = graph[course].get(i);
            if (!graph[course].isEmpty() && !visited[dependingCourse] && dfs(graph, order, visited, index, dependingCourse)) {
                graph[course].remove(i);
                i--;
            }
            i++;
        }

        visited[course] = false;

        if (graph[course].isEmpty()) {
            order[index.index] = course;
            index.index++;
            return true;
        }

        return false;
    }

    private static boolean isFinished(int[] order, Integer index, int course) {
        for (int i = 0; i < index; i++) {
            if (order[i] == course) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        int[][] graph = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        int numberOfCourses = 4;

        System.out.println(Arrays.toString(findOrder(numberOfCourses, graph)));

        graph = new int[][]{
                {1, 0}
        };

        numberOfCourses = 2;

        System.out.println(Arrays.toString(findOrder(numberOfCourses, graph)));

        graph = new int[][]{
                {0, 1},
                {1, 0}
        };

        numberOfCourses = 2;

        System.out.println(Arrays.toString(findOrder(numberOfCourses, graph)));
    }
}
