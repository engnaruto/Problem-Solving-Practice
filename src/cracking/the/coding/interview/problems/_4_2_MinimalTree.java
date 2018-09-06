package cracking.the.coding.interview.problems;


import data.structures.implementations.binary.search.tree.BSTree;
import data.structures.implementations.binary.search.tree.Node;

/*
    4.2
    Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
    to create a binary search tree with minimal height.
*/

public class _4_2_MinimalTree {


    /*
        WRONG ANSWER
    */
    public static BSTree minimalTree2(int[] arr) {

        int middle = arr.length % 2 == 0 ? (arr.length / 2) : ((arr.length / 2) + 1);

        BSTree tree = new BSTree();

        tree.insert(arr[middle]);

        for (int i = 0; i < middle; i++) {
            tree.insert(arr[i]);
        }

        for (int i = middle + 1; i < arr.length; i++) {
            tree.insert(arr[i]);
        }
        return tree;
    }


    /*
        Time: O(N Log N) Each insertion will require traversing the tree, giving a total cost of O(N log N) to the tree
    */

    public static Node minimalTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        Node n = new Node(arr[mid]);

        n.left = minimalTree(arr, start, mid - 1);
        if (n.left != null) { // for _4_6_Successor problem
            n.left.parent = n;
        }
        n.right = minimalTree(arr, mid + 1, end);
        if (n.right != null) { // for _4_6_Successor problem
            n.right.parent = n;
        }
        return n;
    }

    public static BSTree minimalTree(int[] arr) {
        BSTree tree = new BSTree();
        tree.size = arr.length;
        tree.root = minimalTree(arr, 0, arr.length - 1);
        return tree;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        BSTree tree = minimalTree(arr);

        tree.printBFS();
        System.out.println("******");
        System.out.println(tree.getLongestBranch());
    }


}
