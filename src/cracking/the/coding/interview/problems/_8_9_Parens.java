package cracking.the.coding.interview.problems;

/*
    8.9
    Parens: Implement an algorithm to print all valid (i.e., properly opened and closed) combinations
    of n pairs of parentheses.

    EXAMPLE

    Input: 3

    Output: ((())) , (()()) , (())() , ()(()) , ()()()
*/

public class _8_9_Parens {

    /*
        Time: O(2 ^ (2 * N))
        Memory: O(N)
    */

    public static void parens(int n) {
        parens(n, n, 0, new char[n * 2]);
    }

    public static void parens(int i, int j, int index, char[] arr) {

        if (i == 0 && j == 0) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
            return;
        } else if (i - j > 0 || i < 0 || j < 0) {
            return;
        }

        arr[index] = '(';
        parens(i - 1, j, index + 1, arr);
        arr[index] = ')';
        parens(i, j - 1, index + 1, arr);
    }

    public static void main(String[] args) {
        parens(3);
    }

}
