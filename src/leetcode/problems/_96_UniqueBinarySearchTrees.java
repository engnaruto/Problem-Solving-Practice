package leetcode.problems;


/*
    Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

    Example:

    Input: 3

    Output: 5

    Explanation:

    Given n = 3, there are a total of 5 unique BST's:

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
*/

public class _96_UniqueBinarySearchTrees {

    public static int dp[];

    public static int solve(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }
        int result = 0;

        for (int i = 1; i <= n; i++) {
            result += solve(i - 1) * solve(n - i);
        }
        return dp[n] = result;
    }


    /*
        Time: O(N)
        Memory: O(N)
        Note: To understand this method you should read this: https://www.geeksforgeeks.org/total-number-of-possible-binary-search-trees-with-n-keys/
    */

    public static int numTrees(int n) {
        dp = new int[n + 1];
        return solve(n);
    }

    public static void main(String[] args) {
        System.out.println(numTrees(1));
        System.out.println(numTrees(2));
        System.out.println(numTrees(3));
        System.out.println(numTrees(4));
        System.out.println(numTrees(5));
    }
}
