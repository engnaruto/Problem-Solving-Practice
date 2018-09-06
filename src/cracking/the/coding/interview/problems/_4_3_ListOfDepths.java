package cracking.the.coding.interview.problems;


import data.structures.implementations.binary.search.tree.BSTree;
import data.structures.implementations.binary.search.tree.Node;

import java.util.*;


/*
    4.3
    List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
    at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).
*/


public class _4_3_ListOfDepths {

    public static HashMap<Integer, LinkedList<Node>> map = new HashMap<>();


    /*
        Time: O(N)
        Memory: O(N)
    */

    public static void listOfDepths(Node root, int depth) {

        if (!map.containsKey(depth)) {
            map.put(depth, new LinkedList<>());
        }
        map.get(depth).add(root);


        if (root.left != null) {
            listOfDepths(root.left, depth + 1);
        }

        if (root.right != null) {
            listOfDepths(root.right, depth + 1);
        }
    }


    /*
        Time: O(N)
        Memory: O(N)
    */

    public static ArrayList<ArrayList<Node>> listOfDepthsBfs(Node root) {

        ArrayList<Node> parent = new ArrayList<>();
        ArrayList<Node> current = new ArrayList<>();

        int depth = 0;


        if (root != null) {
            parent.add(root);
        }

        ArrayList<ArrayList<Node>> lists = new ArrayList<>();

        lists.add(new ArrayList<>());

        lists.get(depth++).add(root);

        while (!parent.isEmpty() || !current.isEmpty()) {
            while (!parent.isEmpty()) {
                Node node = parent.remove(0);
                if (node.left != null) {
                    current.add(node.left);
                }
                if (node.right != null) {
                    current.add(node.right);
                }
            }

            parent = (ArrayList<Node>) current.clone();

            if (!current.isEmpty()) {

                lists.add(new ArrayList<>());
                while (!current.isEmpty()) {
                    lists.get(depth).add(current.remove(0));
                }
                depth++;
            }
        }

        return lists;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        BSTree tree = _4_2_MinimalTree.minimalTree(arr);

        listOfDepths(tree.root, 0);

        for (Map.Entry<Integer, LinkedList<Node>> entry : map.entrySet()) {
            System.out.println(Arrays.toString(entry.getValue().toArray()));
        }


        System.out.println("****************");
        ArrayList<ArrayList<Node>> lists = listOfDepthsBfs(tree.root);

        for (ArrayList<Node> list : lists) {
            System.out.println(list.toString());
        }

    }


}
