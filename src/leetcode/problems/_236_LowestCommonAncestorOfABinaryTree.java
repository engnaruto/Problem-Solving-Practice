package leetcode.problems;


/*
    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
    as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

    Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]




    Example 1:

    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    Output: 3
    Explanation: The LCA of nodes 5 and 1 is 3.
    Example 2:

    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    Output: 5
    Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


    Note:

    All of the nodes' values will be unique.
    p and q are different and both values will exist in the binary tree.

*/

public class _236_LowestCommonAncestorOfABinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public static boolean search(TreeNode root, TreeNode value) {
        if (root == null) {
            return false;
        }

        if (root == value) {
            return true;
        }

        return search(root.left, value) || search(root.right, value);
    }

    public static TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p) {
            return p;
        }
        if (root == q) {
            return q;
        }

        if (search(root.right, p) && search(root.right, q)) {
            return find(root.right, p, q);
        }
        if (search(root.left, p) && search(root.left, q)) {
            return find(root.left, p, q);
        }
        if ((search(root.right, p) && search(root.left, q)) || (search(root.left, p) && search(root.right, q))) {
            return root;
        }

        return null;
    }


    public static TreeNode find1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p) {
            return p;
        }
        if (root == q) {
            return q;
        }

        int directionP = 0;
        int directionQ = 0;

        if (search(root.right, p)) {
            directionP++;
        } else if (search(root.left, p)) {
            directionP--;
        }

        if (search(root.right, q)) {
            directionQ++;
        } else if (search(root.left, q)) {
            directionQ--;
        }

        if (directionP + directionQ == 0) {
            return root;
        } else if (directionP + directionQ > 0) {
            return find1(root.right, p, q);
        } else {
            return find1(root.left, p, q);
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find1(root, p, q);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(lowestCommonAncestor(root, root.left, root.right).val);
        System.out.println(lowestCommonAncestor(root, root.left, root.left.right.right).val);
    }
}
