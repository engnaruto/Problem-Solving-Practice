package cracking.the.coding.interview.problems;


import data.structures.implementations.binary.search.tree.Node;

import java.util.HashMap;


/*
    4.12
    Paths with Sum: You are given a binary tree in which each node contains an integer value (which
    might be positive or negative). Design an algorithm to count the number of paths that sum to a
    given value. The path does not need to start or end at the root or a leaf, but it must go downwards
    (traveling only from parent nodes to child nodes).
*/

public class _4_12_PathsWithSum {

    /*
        Time: O(N * Log(N))
        Memory: O(Log(N)) Max stack size
    */

    public static int pathsWithSum(Node root, boolean start, int value) {

        if (root == null) {
            return 0;
        }

        int v = 0;

        value -= root.value;
        if (value == 0) {
            v = 1;
        }

        if (start) { // we can make the part of the else condition out of the else and remove it from the if condition too
            v += pathsWithSum(root.left, false, value) +
                    pathsWithSum(root.right, false, value);

            value += root.value;

            v += pathsWithSum(root.left, true, value) +
                    pathsWithSum(root.right, true, value);
        } else {
            v += pathsWithSum(root.left, false, value) +
                    pathsWithSum(root.right, false, value);
        }

        return v;
    }


    public static HashMap<Integer, Integer> map = new HashMap<>();


    /*
        Time: O(N)
        Memory: O(Log(N)) Max stack size
    */


    public static int pathsWithSumUsingHashMap(Node root, int value, int sum) {

        if (root == null) {
            return 0;
        }

        int v = 0;

        int val = sum + root.value;

        if (val == value) {
            v++;
        }

        if (map.containsKey(val)) {
            map.put(val, map.get(val) + 1);
        } else {
            map.put(val, 1);
        }

        if (map.containsKey(val - value)) {
            v += map.get(val - value);
        }

        v += pathsWithSumUsingHashMap(root.left, value, val)
                + pathsWithSumUsingHashMap(root.right, value, val);

        if (map.containsKey(val) && map.get(val) == 1) {
            map.remove(val);
        } else {
            map.put(val, map.get(val) - 1);
        }
        return v;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(0);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.left.right.right = new Node(4);
        root.right = new Node(8);
        root.right.left = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right = new Node(9);
        root.right.right.right = new Node(10);

        System.out.println(pathsWithSum(root, true, 7));
        System.out.println(pathsWithSumUsingHashMap(root, 7, 0));


//        Node root = new Node(1);
//        root.left = new Node(5);
//        root.left.left = new Node(0);
//        root.left.left.left = new Node(3);
//        root.left.left.left.left = new Node(-3);
//        root.left.left.left.left.left = new Node(6);
//
//        System.out.println(pathsWithSum(root, true, 6));
//        System.out.println(pathsWithSumUsingHashMap(root, 6, 0));

    }
}
