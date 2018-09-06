package cracking.the.coding.interview.problems;



/*
    4.7
    Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
    projects, where the second project is dependent on the first project). All of a project's dependencies
    must be built before the project is. Find a build order that will allow the projects to be built.
    If there is no valid build order, return an error.

    EXAMPLE

    Input:
    projects: a, b, c, d, e, f
    dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)

    Output: f, e, a, b, d, c
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class _4_7_BuildOrder {

    public static class Pair {
        char s, d;

        Pair(char source, char destination) {
            s = source;
            d = destination;
        }
    }

    public static int counter = 0;
    public static HashMap<Character, Integer> map;
    public static ArrayList<Character>[] graph;
    public static int index = 0;
    public static int[] order;
    public static boolean isExecuted[];
    public static boolean visited[];


    /*
       Time: O(E + V)
    */

    public static char[] buildOrder(char[] projects, Pair[] dependencies) {
        buildGraph(projects, dependencies);

        for (int i = 0; i < graph.length; i++) {
            if (graph[i].size() == 0 && !isExecuted[i]) {
                isExecuted[i] = true;
                order[index++] = i;
            } else {
                Arrays.fill(visited, false);
                dfs(i);
            }
        }

        for (boolean b : isExecuted) {
            if (!b) {
                return null;
            }
        }


        char[] projectsOrder = new char[projects.length];
        int j = 0;
        for (int i = 0; i < order.length; i++) {
            projectsOrder[j++] = (char) ('a' + order[i]);
        }
        return projectsOrder;


    }

    private static void buildGraph(char[] projects, Pair[] dependencies) {
        map = new HashMap<>();
        for (char c : projects) {
            map.put(c, counter++);
        }
        graph = new ArrayList[projects.length];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }


        for (Pair p : dependencies) {
            graph[map.get(p.d)].add(p.s);
        }

        order = new int[projects.length];
        isExecuted = new boolean[projects.length];
        visited = new boolean[projects.length];


        for (int i = 0; i < graph.length; i++) {
            char c = (char) ('a' + i);
            System.out.println(c + ": " + graph[i].toString());
        }
        System.out.println();
    }

    private static boolean dfs(int i) {

        if (isExecuted[i]) {
            return true;
        }

        if (visited[i]) {
            return false;
        } else {
            visited[i] = true;
        }

        int j = 0;
        while (j < graph[i].size()) {
            if (isExecuted[getProject(i, j)] || dfs(getProject(i, j))) {
                graph[i].remove(j);
            } else {
                j++;
            }
        }

        if (!isExecuted[i] && graph[i].isEmpty()) {
            isExecuted[i] = true;
            order[index++] = i;
            return true;
        }

        return false;
    }

    private static int getProject(int i, int j) {
        return map.get(graph[i].get(j));
    }


    public static void main(String[] args) {
//        char[] projects = {'a', 'b', 'c', 'd', 'e', 'f'};
//        Pair[] dependencies = new Pair[5];
//
//        dependencies[0] = new Pair('a', 'd');
//        dependencies[1] = new Pair('f', 'b');
//        dependencies[2] = new Pair('b', 'd');
//        dependencies[3] = new Pair('f', 'a');
//        dependencies[4] = new Pair('d', 'c');




        char[] projects = {'a', 'b', 'c', 'd', 'e', 'f','g'};
        Pair[] dependencies = new Pair[8];

        dependencies[0] = new Pair('f', 'c');
        dependencies[1] = new Pair('f', 'a');
        dependencies[2] = new Pair('f', 'b');
        dependencies[3] = new Pair('c', 'a');
        dependencies[4] = new Pair('b', 'a');
        dependencies[5] = new Pair('b', 'e');
        dependencies[6] = new Pair('a', 'e');
        dependencies[7] = new Pair('d', 'g');


        System.out.println(Arrays.toString(buildOrder(projects, dependencies)));

    }


}
