package cracking.the.coding.interview.problems;


import data.structures.implementations.binary.search.tree.BSTree;
import data.structures.implementations.binary.search.tree.Node;

import java.util.ArrayList;

import static cracking.the.coding.interview.problems._4_2_MinimalTree.minimalTree;


/*
    4.9
    BST Sequences: A binary search tree was created by traversing through an array from left to right
    and inserting each element. Given a binary search tree with distinct elements, print all possible
    arrays that could have led to this tree.

    EXAMPLE
    Input:
             2
            / \
           1   3

    Output: {2, 1, 3}, {2, 3, 1}

*/


public class _4_9_BSTSequences {

    /*
            NOT COMPLETED
    */

    public static void bstSequences(){

        ArrayList<ArrayList<Node>> result = new ArrayList<>();

    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        BSTree tree = minimalTree(arr);

        tree.printBFS();
        System.out.println("*****");
        tree.printPreorder();
        System.out.println("==============");
        BSTree t = new BSTree();
        t.insert(5);
        t.insert(2);
        t.insert(8);
        t.insert(1);
        t.insert(3);
        t.insert(6);
        t.insert(9);
        t.insert(4);
        t.insert(7);
        t.insert(10);

        BSTree tt = new BSTree();
        tt.insert(5);
        tt.insert(2);
        tt.insert(1);
        tt.insert(3);
        tt.insert(4);
        tt.insert(8);
        tt.insert(6);
        tt.insert(7);
        tt.insert(9);
        tt.insert(10);

        t.printPreorder();
        System.out.println("*****");
        tt.printPreorder();
        System.out.println("==============");
    }


}
